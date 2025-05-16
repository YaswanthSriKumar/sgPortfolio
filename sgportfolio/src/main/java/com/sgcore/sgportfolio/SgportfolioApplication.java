package com.sgcore.sgportfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class SgportfolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(SgportfolioApplication.class, args);
	}

}
