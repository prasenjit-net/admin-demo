package net.prasenjit.admin.server;

import de.codecentric.boot.admin.config.EnableAdminServer;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableAdminServer
@EnableDiscoveryClient
public class AdminDemoServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(AdminDemoServerApplication.class, args);
    }

    @Bean
    public Sampler<Void> sampler(){
        return new AlwaysSampler();
    }
}
