package com.space.OurSpace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

// Lets your project know its a spring boot application
@SpringBootApplication

// Lets your project know where all your Spring Beans are
// Spring beans are your annotated classes, like controllers, services, entities, repos
@ComponentScan(basePackages="com.space")
public class OurSpaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OurSpaceApplication.class, args);
	}

}
