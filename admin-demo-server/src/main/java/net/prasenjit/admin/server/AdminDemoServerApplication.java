package net.prasenjit.admin.server;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableAdminServer
@EnableDiscoveryClient
public class AdminDemoServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminDemoServerApplication.class, args);
    }
}
