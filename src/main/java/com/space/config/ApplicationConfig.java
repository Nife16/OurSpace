package com.space.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories(basePackages="com.space.repo")
@EntityScan(basePackages="com.space.entity")
public class ApplicationConfig {

}
