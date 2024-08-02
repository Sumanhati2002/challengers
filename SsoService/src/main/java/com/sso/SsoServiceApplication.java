package com.sso;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class SsoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(SsoServiceApplication.class, args);
	}
}