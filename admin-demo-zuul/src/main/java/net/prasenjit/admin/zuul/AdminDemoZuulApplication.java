package net.prasenjit.admin.zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.sleuth.Sampler;
import org.springframework.cloud.sleuth.sampler.AlwaysSampler;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
public class AdminDemoZuulApplication {

    @Bean
    public Sampler<Void> sampler(){
        return new AlwaysSampler();
    }

    public static void main(String[] args) {
        SpringApplication.run(AdminDemoZuulApplication.class, args);
    }
}
