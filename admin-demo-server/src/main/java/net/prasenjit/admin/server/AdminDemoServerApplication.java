package net.prasenjit.admin.server;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAdminServer
public class AdminDemoServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminDemoServerApplication.class, args);
    }
}
