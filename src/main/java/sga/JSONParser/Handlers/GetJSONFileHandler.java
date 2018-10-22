package sga.JSONParser.Handlers;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.THttpClient;
import org.springframework.stereotype.Service;
import sga.JSONParser.Services.*;

@Service
public class GetJSONFileHandler implements GetJSONService.Iface {

	public String getJSONFile(String fileName) throws TException {
		
		//request dbloader to send json object
		
		return "Some JSON String of "+ fileName;
	}

}
