package com.handler.tracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories("com.handler.tracker.repo.TestRepo")
public class TrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrackerApplication.class, args);
	}

}

