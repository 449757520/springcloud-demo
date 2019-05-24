package com.example.eurekaconsumerclient.web;
import com.example.eurekaconsumerclient.feign.UserFeignClientWithFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
class TestController {
    @Autowired
    private UserFeignClientWithFactory userFeignClient;
    @GetMapping("/test/{name}")
    public String test(@PathVariable("name")String name){
        return userFeignClient.test(name);
    }
}
