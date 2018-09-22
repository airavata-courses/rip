package com.kafka.extractor.controller;

import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kafka.extractor.document.FilesMongoDB;
import com.kafka.extractor.repository.DataRepository;

@RestController
@RequestMapping("/use")
public class FilesController { 
	
	private DataRepository datarepository;
	
	
	public FilesController(DataRepository datarepository) {
		this.datarepository = datarepository;
	}

	@GetMapping("/all")
	public List<FilesMongoDB> getAll(){
		
		List<FilesMongoDB> use = this.datarepository.findAll();
		return use;
	}
	
}
