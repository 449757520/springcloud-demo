package com.example.eurekaconsumerclient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
@SpringBootApplication
@EnableFeignClients     //开启声明式web服务
@EnableEurekaClient     //开启为服务
public class EurekaConsumerFeignClientConfigApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaConsumerFeignClientConfigApplication.class, args);
    }

}
