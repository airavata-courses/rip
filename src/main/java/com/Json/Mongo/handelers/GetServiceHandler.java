package com.Json.Mongo.handelers;



import static com.mongodb.client.model.Filters.eq;

import java.util.ArrayList;

import org.apache.thrift.TException;
import org.bson.Document;
import org.springframework.stereotype.Service;

import com.Json.Mongo.services.*;
import com.google.gson.Gson;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoIterable;

@Service
public class GetServiceHandler implements GetService.Iface {

	
	public String GetJSON(String JSONStr) throws TException {
		// TODO Auto-generated method stub
		
				MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://sgauser:sgauser@sgamongodb-shard-00-00-ceccc.mongodb.net:27017,sgamongodb-shard-00-01-ceccc.mongodb.net:27017,sgamongodb-shard-00-02-ceccc.mongodb.net:27017/test?ssl=true&replicaSet=SGAMongoDb-shard-0&authSource=admin&retryWrites=true"));
		        MongoDatabase database = mongoClient.getDatabase("testdb2");
		        MongoCollection<Document> collection = database.getCollection("wav5");
		        
		//*** Adding Conditions for fetching query ***
		        DBObject clause1 = new BasicDBObject("ElementName", JSONStr);
		        DBObject clause2 = new BasicDBObject("Spectra","exc");
		        
		//*** Making the query ***
		        BasicDBList or = new BasicDBList();
		        or.add(clause1);
		        or.add(clause2);
		        BasicDBObject query = new BasicDBObject();
		        query.put("$and", or);
		        System.out.println(query);
		        
		        
		//*** Fetching Data by executing the query ***  
		        FindIterable<Document> du = collection.find(query);

		//*** Creating and Adding data to the ArrayList ***  
		        ArrayList<String> myList = new ArrayList<>();        
		        for (Document doc : du) {
		        	myList.add(new Gson().toJson((((Document) doc).get("Coordinates"))));
		        }

		//*** converting the list into a JSON String ***  
		        String json = new Gson().toJson(myList);

		        return json;

	}
	
	
	
	
}
