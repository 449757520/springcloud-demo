package com.example.eurekaproviderclient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
@SpringBootApplication
//服务提供者 等价于@EnableClient
@EnableDiscoveryClient
public class EurekaFileUploadApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaFileUploadApplication.class, args);
    }

}
