package com.lmt.fabricanteback;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = SecurityAutoConfiguration.class)
public class FabricanteBackApplication {

	public static void main(String[] args) {
		SpringApplication.run(FabricanteBackApplication.class, args);
	}

};
