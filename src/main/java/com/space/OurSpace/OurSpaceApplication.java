package com.space.OurSpace;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan(basePackages="com.space")
public class OurSpaceApplication {

	public static void main(String[] args) {
		SpringApplication.run(OurSpaceApplication.class, args);
	}

}
