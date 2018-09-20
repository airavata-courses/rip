package com.techprimers.kafka.springbootkafkaconsumerexample.document;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Users {
	
	@Id
	private Integer id;
	private String fileName;
	private String data;
	private String fileType;



public Users (Integer id, String fileName,String data, String fileType) {
	
	this.id = id;
	this.fileName = fileName;
	this.data = data;
	this.fileType = fileType;
}


public Integer getId() {
    return id;
}

public void setId(Integer id) {
    this.id = id;
}

public String getfileName() {
    return fileName;
}

public void setfileName(String fileName) {
    this.fileName = fileName;
}

public String getdata() {
    return data;
}

public void setdata(String data) {
    this.data = data;
}

public String getfileType() {
    return fileType;
}

public void setfileType(String fileType) {
    this.fileType = fileType;
}





}