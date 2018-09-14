package rc.springbootmongodbdemo;


import org.springframework.data.mongodb.repository.MongoRepository;
//import org.springframework.data.annotation.Id;
//import org.springframework.data.mongodb.core.index.IndexDirection;
//import org.springframework.data.mongodb.core.index.Indexed;
//import org.springframework.data.mongodb.core.mapping.Document;
//import org.springframework.data.mongodb.core.MongoTemplate;


import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HotelRepository extends MongoRepository<Hotel,String> {
   
}
