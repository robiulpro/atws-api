package com.browntape.amz.tws.ATWS_Ext;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.browntape.amz.tws.controller","com.browntape.amz.tws.impl"})
public class AtwsExtApplication {

	public static void main(String[] args) {
		SpringApplication.run(AtwsExtApplication.class, args);
	}

}
