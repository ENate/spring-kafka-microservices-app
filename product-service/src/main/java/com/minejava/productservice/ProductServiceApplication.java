package com.minejava.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.mongo.MongoReactiveAutoConfiguration;

// @EnableAutoConfiguration(exclude={MongoReactiveAutoConfiguration.class})

@SpringBootApplication(exclude = {MongoReactiveAutoConfiguration.class})
public class ProductServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProductServiceApplication.class, args);
	}

}
