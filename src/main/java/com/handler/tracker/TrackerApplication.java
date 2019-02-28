package com.handler.tracker;

import com.handler.tracker.repo.RegistrationRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;


/**
 * https://www.callicoder.com/spring-boot-spring-security-jwt-mysql-react-app-part-2/
 */
@SpringBootApplication
@EnableAsync
public class TrackerApplication {

	public static void main(String[] args) {
		SpringApplication.run(TrackerApplication.class, args);
	}

	@Bean(name = "ser")
	public Executor executor() {
		return new ThreadPoolTaskExecutor();
	}

}

