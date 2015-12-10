package net.prasenjit.admin.service;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

@RestController
@SpringBootApplication
@EnableDiscoveryClient
public class AdminDemoServiceApplication {

	@Bean
	public Sampler<Void> sampler(){
		return new AlwaysSampler();
	}

	public static void main(String[] args) {
		SpringApplication.run(AdminDemoServiceApplication.class, args);
	}
}
