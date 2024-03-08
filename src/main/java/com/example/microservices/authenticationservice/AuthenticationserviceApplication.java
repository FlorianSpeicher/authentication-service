package com.example.microservices.authenticationservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication
public class AuthenticationserviceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AuthenticationserviceApplication.class, args);
	}

}
