package com.sga.project.handlers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.thrift.TException;
import org.apache.thrift.protocol.TBinaryProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.THttpClient;
import org.json.JSONArray;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.sga.project.services.*;
import com.sga.project.transferables.Coordinate;
import com.sga.project.transferables.CoordinateList;
import com.sga.project.transferables.ElementCoordsPair;

@Service
public class GetJSONFileHandler implements GetJSONService.Iface {

	@Override
	public String getJSONFile(String tempList) throws TException {
		
		List<ElementCoordsPair> result = new ArrayList<ElementCoordsPair>();
		
		THttpClient transport = new THttpClient("http://149.165.156.103:8810/getjsonfile");
		TProtocol protocol = new TBinaryProtocol(transport);
		GetService.Client client = new GetService.Client(protocol);
		
		for(String s : GetFiles(tempList)) {
			List<Coordinate> coordList = new Gson().fromJson(client.GetJSON(s), new TypeToken<List<Coordinate>>(){}.getType());
			result.add(new ElementCoordsPair(s, coordList));
		}
		
		return new GsonBuilder().create().toJson(result);
	}
	
	private String[] GetFiles(String files)
	{
		String[] fileList= files.split("--");
		for(int i = 0;i<fileList.length;i++) {
			fileList[i] = fileList[i].substring(0,fileList[i].length());
		}
		return fileList;
	}
}