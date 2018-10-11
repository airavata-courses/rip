package com.kafka.extractor.SpectraProcessor;

import java.io.File;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVParser;
import org.apache.commons.csv.CSVRecord;
import org.springframework.stereotype.Service;
import com.google.gson.Gson;
import com.kafka.extractor.Entities.*;


@Service("ms")
public class SpectraProcessor {
	
	private static final int COORDINATE_START = 22;
	private static final int COORDINATE_START_LIFETIME = 10;
	
	public String processFile(String path)
	{
    	int coordinatesptr = 1;
    	int coordinateLimit = 0;
    	File file = new File(path);
    	String[] parts;
    	
    	ArrayList<Coordinate> coordinates = new ArrayList<>();
		try
    	{
			Reader reader = Files.newBufferedReader(Paths.get(file.getAbsolutePath()));
            CSVParser csvParser = new CSVParser(reader, CSVFormat.DEFAULT);

            parts = file.getName().split("_");
			coordinateLimit = parts[2].equalsIgnoreCase("lifetime") ? COORDINATE_START_LIFETIME : COORDINATE_START;
			
			for (CSVRecord csvRecord : csvParser) {
                if(coordinatesptr < coordinateLimit)
                {
                	coordinatesptr ++;
                	continue;
                }
                
                coordinates.add(new Coordinate(Double.parseDouble(csvRecord.get(0)),Double.parseDouble(csvRecord.get(1))));
    		}
			
    		return new Gson().toJson(new MetaData(parts[0],parts[1],parts[2],parts[3].substring(0, parts[3].length()-4),coordinates));
    	}
		catch(Exception e)
		{
			return "";
		}
    	
	}
}
