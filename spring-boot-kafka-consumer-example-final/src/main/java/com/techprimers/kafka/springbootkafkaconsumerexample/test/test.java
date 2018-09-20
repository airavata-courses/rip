package com.techprimers.kafka.springbootkafkaconsumerexample.test;


import java.io.IOException;
import java.util.*;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.techprimers.kafka.springbootkafkaconsumerexample.document.Users;
import com.techprimers.kafka.springbootkafkaconsumerexample.repository.DataRepository;

@Component
public class test{
	
	private DataRepository datarepository;
//	private String[] args;
//	
	public test(DataRepository datarepository) {
		this.datarepository = datarepository;
	}
	

	
	public String t_st;
	
	public test() {}
	
	public test(String t_st) {
		this.t_st = t_st;
//		args[0] = t_st;
		display(t_st);
//		
	}
	
	
	
	public void display(String t) {
//		this.t = t;
		System.out.println(t+"0000");
		
		
		Users check = new Users(
			1,t_st,t_st,t_st
			);
	
		this.datarepository.deleteAll();
	
		List<Users> use = Arrays.asList(check);
		this.datarepository.save(use);
		
		
	}
	
	
//	public void r(String... args) throws Exception {
//		// TODO Auto-generated method stub
////		System.out.println("0000");
////		display(t_st);
//		
////		this.args = args;
////		String a = getArgs();
//		System.out.println(args+"test");
//		
////		System.out.println("PrintingABC");
////		SSS
////		
////		Users check = new Users(
////				1,t_st,t_st,t_st
////				);
////		
////		this.datarepository.deleteAll();
////		
////		List<Users> use = Arrays.asList(check);
////		this.datarepository.save(use);
//	}
	
//	public void getArgs(String s) {
//		
//		try {
//		r(s);
//		}
//		catch(Exception e) {}
//		
////        return args;
//    }
	
	
	
	
	
}
