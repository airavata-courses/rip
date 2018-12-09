package com.sga.project.handlers;
import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.THttpClient;
import org.springframework.stereotype.Service;

import com.sga.project.services.*;

@Service
public class GetAllFilesServiceHandler implements GetAllFilesService.Iface{

	@Override
	public String getAllFiles() throws TException {
		// TODO Auto-generated method stub
		THttpClient transport = new THttpClient("http://149.165.156.103:8810/getAllFiles");
	    TProtocol protocol = new TBinaryProtocol(transport);
	    GetAllFilesService.Client client = new GetAllFilesService.Client(protocol);
		return client.getAllFiles();
	}

}
	