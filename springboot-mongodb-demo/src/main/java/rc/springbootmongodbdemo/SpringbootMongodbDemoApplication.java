package rc.springbootmongodbdemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.IndexDirection;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.MongoTemplate;

@SpringBootApplication
@ServletComponentScan
public class SpringbootMongodbDemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMongodbDemoApplication.class, args);
	}
}
