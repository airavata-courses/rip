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
		MongoClient mongoClient = new MongoClient(new MongoClientURI("mongodb://sgauser:sgauser@sgamongodb-shard-00-00-ceccc.mongodb.net:27017,sgamongodb-shard-00-01-ceccc.mongodb.net:27017,sgamongodb-shard-00-02-ceccc.mongodb.net:27017/test?ssl=true&replicaSet=SGAMongoDb-shard-0&authSource=admin&retryWrites=true"));
        MongoDatabase database = mongoClient.getDatabase("testdb2");
        MongoCollection<Document> collection = database.getCollection("wav5");
        
        Object doc = database.getCollection("wav5").find(eq("FileName", JSONStr)).first();
        
	    return doc == null?"{}" : new Gson().toJson((((Document) doc).get("Coordinates")));
	}
	
	
	
	
}
