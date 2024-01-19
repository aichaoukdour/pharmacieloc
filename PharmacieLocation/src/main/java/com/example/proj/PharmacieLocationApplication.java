package com.example.proj;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;

@SpringBootApplication
@EntityScan(basePackages = "entities")
public class PharmacieLocationApplication {

	public static void main(String[] args) {
		SpringApplication.run(PharmacieLocationApplication.class, args);
	}

}
