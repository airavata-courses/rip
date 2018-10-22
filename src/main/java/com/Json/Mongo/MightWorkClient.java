package com.Json.Mongo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.util.List;
import java.util.Scanner;
import javax.naming.AuthenticationException;
import javax.servlet.UnavailableException;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.THttpClient;
import org.apache.thrift.transport.TTransportException;

import com.Json.Mongo.services.GetService;
import com.Json.Mongo.services.InsertService;

public class MightWorkClient {

	public static void main(String[] args) throws AuthenticationException, TException, UnavailableException, IOException {
	    
	    Scanner scan = new Scanner(System.in);
	    int choice = 0;
	    do {
//	    	printMenu();
	    	choice = scan.nextInt();
	    	
	    	switch(choice)
	    	{
	    		case 1:
	    			THttpClient transport = new THttpClient("http://localhost:8080/insertservice");
	    		    
	    		    TProtocol protocol = new TBinaryProtocol(transport);
	    		    
	    		    InsertService.Client client = new InsertService.Client(protocol);
	    		    System.out.println(client.InsertJSON("testing"));
//	    		    System.out.print("Enter the message to echo: ");
//	    		    scan.nextLine();
//	                String msg = scan.nextLine();
//	                
//	    		    String reply = client.echo(msg);
//	    		    System.out.println(reply);
	    		    System.out.println("HI");
	    		    break;
	    		    
	    		case 2:
	    			THttpClient transport1 = new THttpClient("http://localhost:8080/getservice");
	    		    
	    		    TProtocol protocol1 = new TBinaryProtocol(transport1);
	    		    
	    		    GetService.Client client1 = new GetService.Client(protocol1);
	    		    System.out.println(client1.GetJSON("R3B"));
//	    		    System.out.print("Enter the message to echo: ");
//	    		    scan.nextLine();
//	                String msg = scan.nextLine();
//	                
//	    		    String reply = client.echo(msg);
//	    		    System.out.println(reply);
	    		    System.out.println("HI FOR GET");
	    		    break;
	    		    
	    		    
	    		    
	    		
	    	}
	    	
	    	
	    	
	    }while(choice < 4);

	}

}
