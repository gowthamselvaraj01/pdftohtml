package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan({"com.example.model"})
@ComponentScan({"com.example.controller","com.example.demo","com.example.service","com.example.service.impl"})
@EnableJpaRepositories("com.example.dao")

public class SpringBootJpaMysqlApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootJpaMysqlApplication.class, args);
		
	}
	
	 

}
