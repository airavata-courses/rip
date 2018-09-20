package com.techprimers.kafka.springbootkafkaconsumerexample.controller;

import java.util.*;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techprimers.kafka.springbootkafkaconsumerexample.document.Users;
import com.techprimers.kafka.springbootkafkaconsumerexample.repository.DataRepository;

@RestController
@RequestMapping("/use")
public class UsersController { 
	
	private DataRepository datarepository;
	
	
	public UsersController(DataRepository datarepository) {
		this.datarepository = datarepository;
	}

	@GetMapping("/all")
	public List<Users> getAll(){
		
		List<Users> use = this.datarepository.findAll();
		return use;
	}
	
}
