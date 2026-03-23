package com.example.tracing.service1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@EnableFeignClients
@ComponentScan(basePackages = "com.example.tracing.service1")
@SpringBootApplication
public class DemoApplication1 {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication1.class, args);
	}

}
