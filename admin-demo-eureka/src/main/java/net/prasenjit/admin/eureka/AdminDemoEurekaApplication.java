package net.prasenjit.admin.eureka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class AdminDemoEurekaApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminDemoEurekaApplication.class, args);
    }
}
