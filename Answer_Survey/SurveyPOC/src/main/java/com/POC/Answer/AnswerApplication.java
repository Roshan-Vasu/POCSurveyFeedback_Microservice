package com.POC.Answer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients	
public class AnswerApplication {

	public static void main(String[] args) {
		SpringApplication.run(AnswerApplication.class, args);
	}

}
