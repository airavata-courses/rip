package com.sga.project;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.sga.project.Configs.OSConfigs;

@SpringBootApplication
public class UploadApiApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OSConfigs.instantiateOSConfigs();
		SpringApplication.run(UploadApiApp.class, args);
	}

}
