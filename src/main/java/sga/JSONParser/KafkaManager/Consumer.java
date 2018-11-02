package sga.JSONParser.KafkaManager;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.THttpClient;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import sga.JSONParser.Configs.OSConfigs;
import sga.JSONParser.Services.InsertService;
import sga.JSONParser.SpectraProcessor.SpectraProcessor;


@Service
@Component
public class Consumer {
	private static final File BASE_DIRECTORY = new File("downloads");
	private ByteBuffer ioBuffer = ByteBuffer.allocate(1024 * 10);
	private Context context;
	private SpectraProcessor processor = new SpectraProcessor();
	
	
	@KafkaListener(topics = "topic1")
    public void consume(ConsumerRecord<?,?> consumerRecord) {
    	System.out.println(consumerRecord.toString());
    	String[] msg = consumerRecord.toString().split(",",10);
    	String[] data = msg[9].toString().split("\"");
    	String[] filenameAndType = data[1].split("\\.");
    	System.out.println("*****file name*****"+filenameAndType[1]);
    	String fi = OSConfigs.sharedDirectoryPath +"/" + data[1];
    	System.out.println(fi);
    	pushJSON(processor.processFile(fi));
	}
	
	
	private static class Context {
        private  RandomAccessFile raf;
    }
	
	private void pushJSON(String jsonMetaData)
	{
		THttpClient transport;
		try {
			transport = new THttpClient("http://mongomanager:8810/insertservice");
			TProtocol protocol = new TBinaryProtocol(transport);
		    InsertService.Client client = new InsertService.Client(protocol);
		    client.InsertJSON(jsonMetaData);
		} catch (TException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
	}
}
