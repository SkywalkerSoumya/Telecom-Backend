package com.soumyajitghosh.telecom.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class TelecomUserApplication {

	public static void main(String[] args) {
		SpringApplication.run(TelecomUserApplication.class, args);
	}
	
	//new add
	 @Bean
	    public RestTemplate restTemplate(){
	        return new RestTemplate();
	    }
	 //end
}
