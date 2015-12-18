package com.me.springboot.sample.log.logback;

import javax.annotation.PostConstruct;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SampleLogbackApplication {
	private static final Logger logger = LoggerFactory.getLogger(SampleLogbackApplication.class);
	
	@PostConstruct
	public void logSomething() {
		System.out.println("jkkkkkkkkkkkkkkkkkkkkkkk");
		logger.debug("Sample Debug Message");
		logger.trace("Sample Trace Message");
		System.out.println("8888888888888888888888888888");
	}
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SampleLogbackApplication.class, args);
	}
}
