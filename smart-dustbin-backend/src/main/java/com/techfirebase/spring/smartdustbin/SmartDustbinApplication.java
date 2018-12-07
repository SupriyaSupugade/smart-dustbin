package com.techfirebase.spring.smartdustbin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.techfirebase.spring.smartdustbin.repository")
@EntityScan("com.techfirebase.spring.smartdustbin.domain")
public class SmartDustbinApplication {

	public static void main(String[] args) {
		SpringApplication.run(SmartDustbinApplication.class, args);
	}
}
