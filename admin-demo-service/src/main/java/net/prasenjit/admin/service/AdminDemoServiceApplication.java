package net.prasenjit.admin.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@SpringBootApplication
@EnableDiscoveryClient
public class AdminDemoServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(AdminDemoServiceApplication.class, args);
	}

	@Autowired
	private ConfigBean configBean;

	@RequestMapping("/")
	public String home() {
		log.trace("a trace message");
		log.debug("a debug message");
		log.info("a info message");
		log.warn("a warn message");
		log.error("a error message");
		return "Hello Service " + configBean.getProperty();
	}
}
