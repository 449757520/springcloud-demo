package com.example.eurekaconsumerclient.feign;
import org.springframework.stereotype.Component;

@Component
public class MyHystrixClientFallback implements TestClient{
    @Override
    public String test(String name) {
        return "测试Hystrix用于FeignClient";
    }
}