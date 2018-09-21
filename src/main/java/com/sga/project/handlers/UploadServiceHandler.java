package com.sga.project.handlers;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.RandomAccessFile;

import org.apache.thrift.TException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.sga.project.transferables.*;
import com.sga.project.services.*;


@Service
public class UploadServiceHandler implements UploadService.Iface{
	
	@Autowired
    private KafkaTemplate<String, TransferInfo> senderHelper;

	private static final File BASE_DIRECTORY = new File("downloads");
	private static final File SHARED_DIRECTORY = new File("D:\\sharedDirectory");
	
	private Context context;
	
	@Override
	public void upload(TransferInfo info) throws TException {
		switch (info.type) {
        case REQUEST:
            beginUpload(info);
            break;

        case PROGRESS:
            progressUpload(info);
            break;

        default:
            throw new TException();
		}
	}
	
	private void beginUpload(TransferInfo info) throws TException {
        try {
            if (!BASE_DIRECTORY.exists()) {
                BASE_DIRECTORY.mkdirs();
            }
            int dot = info.fileName.lastIndexOf('.');
            String ext = dot != -1 ? info.fileName.substring(dot, info.fileName.length()) : ".unknown";
            String name = dot != -1 ? info.fileName.substring(0, info.fileName.length() - ext.length()) : info.fileName;

            context = new Context();
            context.file = File.createTempFile(name, ext, BASE_DIRECTORY);
            context.raf = new RandomAccessFile(context.file, "rw");
            context.length = info.length;
        } catch (IOException e) {
            try {
                context.raf.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            throw new TException(e);
        }
    }
	
	
	private void progressUpload(TransferInfo info) throws TException {
        try {
        	senderHelper.send("topic1",info);
            context.raf.getChannel().write(info.data, context.raf.length());
            if (context.file.length() == context.length) {
                context.raf.close();
                String name = copyFileUsingStream(context);
                System.out.println(name);
            }
        } catch (IOException e) {
            try {
                context.raf.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            context.file.delete();
            throw new TException(e);
        }
    }
	
	private String copyFileUsingStream(Context ctx) throws IOException {
		File source = new File(BASE_DIRECTORY+"\\"+ctx.file.getName());
        File dest = new File(SHARED_DIRECTORY+"\\"+ctx.file.getName());
        
	    InputStream is = null;
	    OutputStream os = null;
	    try {
	        is = new FileInputStream(source);
	        os = new FileOutputStream(dest);
	        byte[] buffer = new byte[1024];
	        int length;
	        while ((length = is.read(buffer)) > 0) {
	            os.write(buffer, 0, length);
	        }
	    } finally {
	        is.close();
	        os.close();
	    }
	    
	    return ctx.file.getName();
	}

	private static class Context {
        private File file;

        private RandomAccessFile raf;

        private long length;
    }

}
