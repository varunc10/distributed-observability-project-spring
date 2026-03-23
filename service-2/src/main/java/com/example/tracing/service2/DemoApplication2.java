package com.example.tracing.service2;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableFeignClients
@ComponentScan(basePackages = "com.example.tracing.service2")
@SpringBootApplication
public class DemoApplication2 {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication2.class, args);
	}

}
