package org.jana.securityservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class SecurityServiceApp {

	public static void main(String[] args) {
		SpringApplication.run(SecurityServiceApp.class, args);
	}

}
