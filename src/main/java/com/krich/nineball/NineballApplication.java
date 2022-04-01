package com.krich.nineball;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class NineballApplication {

	public static void main(String[] args) {
		SpringApplication.run(NineballApplication.class, args);
	}

}
