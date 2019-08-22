package com.es.eoi.rest.pruebarest;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages = "com.es.eoi")
public class PruebarestApplication {

	public static void main(String[] args) {
		SpringApplication.run(PruebarestApplication.class, args);
	}

}
