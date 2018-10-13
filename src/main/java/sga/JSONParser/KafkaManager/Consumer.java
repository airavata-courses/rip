package sga.JSONParser.KafkaManager;

import java.io.File;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

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
    	String fi = "C:\\sharedDirectory\\" + data[1];
    	
    	String jsonVal = processor.processFile(fi);
    	System.out.println(jsonVal);
	}
	
	
	private static class Context {
        private  RandomAccessFile raf;
    }
}
