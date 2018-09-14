package rc.springbootmongodbdemo;

import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

public class Address {
    private String city;
    private String country;

    protected Address(){}
    
    public Address(String city, String country) {
    	this.city = city;
    	this.country = country;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }
}