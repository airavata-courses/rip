package com.Json.Mongo.handelers;



import static com.mongodb.client.model.Filters.eq;

import java.awt.List;
import java.util.ArrayList;

import org.apache.thrift.TException;
import org.bson.BsonDocument;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.springframework.stereotype.Service;
import com.mongodb.client.model.Filters.*;

import com.Json.Mongo.services.*;
import com.google.gson.Gson;
import com.mongodb.BasicDBList;
import com.mongodb.BasicDBObject;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;

@Service
public class GetAllFilesHandler implements GetAllFilesService.Iface {

	
	
	@Override
	public String getAllFiles() throws TException {
		// TODO Auto-generated method stub
		MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://sgauser:sgauser@sgamongodb-shard-00-00-ceccc.mongodb.net:27017,sgamongodb-shard-00-01-ceccc.mongodb.net:27017,sgamongodb-shard-00-02-ceccc.mongodb.net:27017/test?ssl=true&replicaSet=SGAMongoDb-shard-0&authSource=admin&retryWrites=true"));
        MongoDatabase database = mongoClient.getDatabase("testdb2");
        MongoCollection<Document> collection = database.getCollection("wav5");
        
        
        FindIterable<Document> du = collection.find();
        
        ArrayList<String> myList = new ArrayList<>();        
        
        
        for (Document doc : du) {
        	if (new Gson().toJson((((Document) doc).get("FileName"))) != null)
        		myList.add(new Gson().toJson((((Document) doc).get("FileName"))));
        }
        
        for (String s : myList) {
        	System.out.println(s);
        }
        
        String json = new Gson().toJson(myList);
        
        return json;
	}
	
}
