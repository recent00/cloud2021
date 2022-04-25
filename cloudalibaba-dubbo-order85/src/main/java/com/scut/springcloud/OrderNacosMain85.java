package com.scut.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@EnableDiscoveryClient
@SpringBootApplication
public class OrderNacosMain85 {
    public static void main(String[] args) {
        SpringApplication.run(OrderNacosMain85.class, args);
    }
}
