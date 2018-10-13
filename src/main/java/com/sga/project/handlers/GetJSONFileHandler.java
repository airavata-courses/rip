package com.sga.project.handlers;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.THttpClient;
import org.springframework.stereotype.Service;

import com.sga.project.services.*;

@Service
public class GetJSONFileHandler implements GetJSONService.Iface {

	@Override
	public String getJSONFile(String fileName) throws TException {
		
		System.out.println("Searching for:" + fileName);
		
		THttpClient transport = new THttpClient("http://localhost:8890/getjsonfile");
		TProtocol protocol = new TBinaryProtocol(transport);
		GetJSONService.Client client = new GetJSONService.Client(protocol);
		
		return client.getJSONFile(fileName);
	}

}
