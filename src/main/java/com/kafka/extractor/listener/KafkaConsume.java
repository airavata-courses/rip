package com.kafka.extractor.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.kafka.extractor.document.FilesMongoDB;
//import com.kafka.extractor.model.User;
import com.kafka.extractor.repository.DataRepository;


import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.thrift.TException;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;


@EnableMongoRepositories(basePackageClasses = DataRepository.class)
@Service
@Component
public class KafkaConsume{
	
	
	
	private DataRepository datarepository;
	
	
	
	private static final File BASE_DIRECTORY = new File("downloads");
	private ByteBuffer ioBuffer = ByteBuffer.allocate(1024 * 10);
	private Context context;
	
	
//    public void run(String... strings) throws Exception{
//    	
//		ConsumerRecord<?,?> cr = consumerRecord;
//    	String record = consume(consumerRecord);
//	}
//	
	
	public KafkaConsume(DataRepository datarepository) {
		this.datarepository = datarepository;
	}
	

	@KafkaListener(topics = "topic1")
    public void consume(ConsumerRecord<?,?> consumerRecord) {
    	System.out.println(consumerRecord.toString());
    	String[] msg = consumerRecord.toString().split(",",10);
    	String[] data = msg[8].toString().split("\"");
    	String[] ty = data[1].split("\\.");
//    	System.out.println(msg);
    	System.out.println("*****file name*****"+ty[1]);
    	
//    	System.out.println(data[2]);
//        System.out.println("Consumed message: " + data[3]);
//        String[] d = data[3].toString().split(",");
//        System.out.println(d[0]);
//        byte[] bObj2 = d[0].getBytes();
//        ByteBuffer buf = ByteBuffer.wrap(bObj2);
//        System.out.println(Arrays.toString(bObj2));
    	
    	
//        
//        
        
//        File src = new File(BASE_DIRECTORY, "Blah.txt");
    	
    	String fi = "D:\\downloads\\" + data[1];
    	System.out.println(fi);

    	
    	
    	String st;
    	String[] l = new String[50];
    	l[0] = "trmp";

    	
        File file = new File("D:\\downloads\\" + data[1]); 
        try {
        BufferedReader br = new BufferedReader(new FileReader(file)); 
        int i = 1;
        
        
        while ((st = br.readLine()) != null) { 
        	l[i] = st;
          System.out.println(st); 
          i++;
        }
        
        System.out.println(l[1]);
        System.out.println(ty[1]);
        
        FilesMongoDB u = new FilesMongoDB(1,data[1],l[1],ty[1]);
        this.datarepository.deleteAll();
    	
		List<FilesMongoDB> use = Arrays.asList(u);
		this.datarepository.save(use);
//        System.out.println(st); 
        }	
        catch(IOException e) {}
      
    }
    


    private static class Context {
        private  RandomAccessFile raf;
    }

}
