package com.techprimers.kafka.springbootkafkaconsumerexample.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.techprimers.kafka.springbootkafkaconsumerexample.repository.DataRepository;


@EnableMongoRepositories(basePackageClasses = DataRepository.class)
@Configuration
public class MongodbConfig {

	
//	@Bean
//	CommandLineRunner commandlinerunner
	
}
