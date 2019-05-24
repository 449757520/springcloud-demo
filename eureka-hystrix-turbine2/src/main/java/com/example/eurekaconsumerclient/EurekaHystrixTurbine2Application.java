package com.example.eurekaconsumerclient;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.turbine.EnableTurbine;
@SpringBootApplication
@EnableTurbine
public class EurekaHystrixTurbine2Application {
    public static void main(String[] args) {
        SpringApplication.run(EurekaHystrixTurbine2Application.class, args);
    }

}
