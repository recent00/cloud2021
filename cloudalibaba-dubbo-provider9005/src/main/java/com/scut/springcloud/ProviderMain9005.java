package com.scut.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class ProviderMain9005 {

    public static void main(String[] args) {
        SpringApplication.run(ProviderMain9005.class);
    }
}
