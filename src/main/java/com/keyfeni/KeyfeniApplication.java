package com.keyfeni;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

@SpringBootApplication
@EnableJpaAuditing
public class KeyfeniApplication {
	public static void main(String[] args) {
		SpringApplication.run(KeyfeniApplication.class, args);
	}
}
