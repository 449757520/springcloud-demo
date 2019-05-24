package com.example.config;
import feign.Contract;
import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//自定义配配置
@Configuration
public class Configuration1 {
    @Bean
    public Contract feignContract() {
        return new feign.Contract.Default();
    }
    @Bean
    Logger.Level feignLoggerLevel() {
        return Logger.Level.FULL;
    }
}
