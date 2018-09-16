package com.techprimers.kafka.springbootkafkaconsumerexample.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.techprimers.kafka.springbootkafkaconsumerexample.model.User;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.util.Arrays;

import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.thrift.TException;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {
	
	private static final File BASE_DIRECTORY = new File("downloads");
	private ByteBuffer ioBuffer = ByteBuffer.allocate(1024 * 10);
	private Context context;

    @KafkaListener(topics = "topic1")
    public void consume(ConsumerRecord<?,?> consumerRecord) {
    	String[] msg = consumerRecord.toString().split(",",10);
    	String[] data = msg[9].split(":",10);
    	System.out.println(msg[9]);
        System.out.println("Consumed message: " + data[3]);
        String[] d = data[3].toString().split(",");
        System.out.println(d[0]);
        byte[] bObj2 = d[0].getBytes();
        ByteBuffer buf = ByteBuffer.wrap(bObj2);
        System.out.println(Arrays.toString(bObj2));
        
        
        
        File src = new File(BASE_DIRECTORY, "Blah.txt");
        
        
            try {
                context = new Context();
                context.raf = new RandomAccessFile(src, "r");
                
            } catch (FileNotFoundException e) {
                try {
                    context.raf.close();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        
        
        try {
            buf = ioBuffer;
            ioBuffer.clear();
            long length = context.raf.getChannel().read(ioBuffer);
            ioBuffer.flip();
            
            ByteArrayInputStream bais = new ByteArrayInputStream(buf.array(), buf.position(), buf.limit());
            
        } catch (IOException e) {
            try {
                context.raf.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
        }
        System.out.println();
    }


    @KafkaListener(topics = "Kafka_Example_json", group = "group_json",
            containerFactory = "userKafkaListenerFactory")
    public void consumeJson(User user) {
        System.out.println("Consumed JSON Message: " + user);
    }
    
    private static class Context {
        private  RandomAccessFile raf;
    }

}
