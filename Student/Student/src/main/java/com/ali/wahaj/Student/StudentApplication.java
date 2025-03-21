package com.ali.wahaj.Student;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
@ComponentScan({ "com.ali.wahaj.controller", "com.ali.wahaj.service" })
@EntityScan("com.ali.wahaj.entity")
@EnableJpaRepositories("com.ali.wahaj.repository")
public class StudentApplication {

	@Value("${address.service.url}")
	private String addressServiceURL;

	public static void main(String[] args) {
		SpringApplication.run(StudentApplication.class, args);
	}

	@Bean
	public WebClient webClient() {

		WebClient webClient = WebClient.builder().baseUrl(addressServiceURL).build();

		return webClient;
	}

}
