package com.sgcore.sgportfolio;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
//@EnableDiscoveryClient
public class SgportfolioApplication {

	public static void main(String[] args) {
		SpringApplication.run(SgportfolioApplication.class, args);
	}

	/*{
		"portfolioId": 1,
			"portfolioName":"test1" ,
			"portfolioImage":"" ,
			"portfolioDescription":"test1",
			"portfolioShow":true,
			"SectorEntity":[
		{
			"sectorId":1,
				"sectorName":"test1",
				"sectorImage":""
		}
    ]

	}*/



}
