package com.ali.wahaj.address;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;


@SpringBootApplication
@ComponentScan({"com.ali.wahaj.controller", "com.ali.wahaj.service"})
@EntityScan("com.ali.wahaj.entity")
@EnableJpaRepositories("com.ali.wahaj.repository")
@EnableDiscoveryClient
public class AddressApplication {

	public static void main(String[] args) {
		SpringApplication.run(AddressApplication.class, args);
	}

}
