package com.me.springboot.sample.velocity;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.velocity.app.VelocityEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.ui.velocity.VelocityEngineUtils;

@SpringBootApplication
public class SampleVelocityApplication implements CommandLineRunner {
	@Value("${application.message}")
	private String message;
	
	@Autowired
	private VelocityEngine engine;
	
	@Override
	public void run(String... arg0) throws Exception {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("time", new Date());
		model.put("message", this.message);
		System.out.println(VelocityEngineUtils.mergeTemplateIntoString(this.engine,
				"welcome.vm", "UTF-8", model));
	}
	
	public static void main(String[] args) throws Exception {
		SpringApplication.run(SampleVelocityApplication.class, args);
	}
}
