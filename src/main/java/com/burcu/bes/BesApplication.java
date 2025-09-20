package com.burcu.bes;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;


@EnableJpaAuditing
@SpringBootApplication
public class BesApplication {
	public static void main(String[] args) {
		SpringApplication.run(BesApplication.class, args);
	}
}
