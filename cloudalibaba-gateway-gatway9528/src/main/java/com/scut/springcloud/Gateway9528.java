package com.scut.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * gateway整合sentinel
 */
@EnableDiscoveryClient
@SpringBootApplication
public class Gateway9528 {
    public static void main(String[] args) {
        SpringApplication.run(Gateway9528.class,args);
    }
}
