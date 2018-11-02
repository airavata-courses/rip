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
		THttpClient transport = new THttpClient("http://mongomanager:8810/getjsonfile");
		TProtocol protocol = new TBinaryProtocol(transport);
		GetService.Client client = new GetService.Client(protocol);
		
		return client.GetJSON(fileName);
	}


}
