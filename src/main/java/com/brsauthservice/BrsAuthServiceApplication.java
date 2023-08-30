package com.brsauthservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class BrsAuthServiceApplication {

    public static void main(String[] args) {
//        SpringApplication.run(BrsAuthServiceApplication.class, args);

        new SpringApplicationBuilder()
                .profiles("dev")
                .sources(BrsAuthServiceApplication.class)
                .run(args);
    }

}
