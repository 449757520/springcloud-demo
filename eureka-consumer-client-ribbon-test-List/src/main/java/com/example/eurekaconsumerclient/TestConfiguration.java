package com.example.eurekaconsumerclient;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//自定义Ribbon的访问原则
@Configuration
@ExcludeFormComponentScan
public class TestConfiguration {
    @Bean
    public IRule ribbonRule(){
        return new RandomRule();
    }
}