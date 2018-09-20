package com.techprimers.kafka.springbootkafkaconsumerexample.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.techprimers.kafka.springbootkafkaconsumerexample.document.Users;

public interface DataRepository extends MongoRepository<Users,Integer>{

}
