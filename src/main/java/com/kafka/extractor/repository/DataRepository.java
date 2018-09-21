package com.kafka.extractor.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.kafka.extractor.document.FilesMongoDB;

public interface DataRepository extends MongoRepository<FilesMongoDB,Integer>{

}
