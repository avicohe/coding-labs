package com.avi.cohen.greeting.card.infra;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({ "com.avi.cohen.greeting.card.rests.controllers",
		"com.avi.cohen.greeting.card.rests.services" })
@EntityScan(basePackages = { "com.avi.cohen.greeting.card.rests.model" })
@EnableJpaRepositories(basePackages = { "com.avi.cohen.greeting.card.rests.services.repo" })
public class GreetingCardApplication {

	public static void main(String[] args) {
		SpringApplication.run(GreetingCardApplication.class, args);
	}

}
