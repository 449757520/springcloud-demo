package com.example.eurekaconsumerclient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
@SpringBootApplication
@EnableZuulProxy

public class EurekaZuulFallbackApplication {
    public static void main(String[] args) {
        SpringApplication.run(EurekaZuulFallbackApplication.class, args);
    }

}
