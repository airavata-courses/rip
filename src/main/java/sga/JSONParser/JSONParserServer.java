package sga.JSONParser;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jackson.JacksonAutoConfiguration;

import sga.JSONParser.Configs.OSConfigs;

@SpringBootApplication
@EnableAutoConfiguration(exclude = { JacksonAutoConfiguration.class })
public class JSONParserServer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		OSConfigs.instantiateOSConfigs();
		SpringApplication.run(JSONParserServer.class, args);
	}

}
