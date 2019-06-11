package com.ing.modelbank;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class INGTMRWBankApplication {
	private static final Logger LOGGER = LogManager.getLogger(INGTMRWBankApplication.class);
	public static void main(String[] args) {
		SpringApplication.run(INGTMRWBankApplication.class, args);
	}

}
