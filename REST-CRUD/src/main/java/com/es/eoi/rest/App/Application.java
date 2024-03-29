package com.es.eoi.rest.App;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.RequestMapping;

@SpringBootApplication
@ComponentScan(basePackages = "com.es.eoi.rest")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

}
