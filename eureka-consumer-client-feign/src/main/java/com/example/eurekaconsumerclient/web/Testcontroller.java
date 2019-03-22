package com.example.eurekaconsumerclient.web;
import com.example.eurekaconsumerclient.feign.TestClient;
import com.example.eurekaconsumerclient.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
class TestController {
    @Autowired
    private TestClient testClient;
    @GetMapping("/test/{name}")
    public String test(@PathVariable("name")String name){
        return testClient.test(name);
    }
    @PostMapping("/test/")
    public User findByUser(@RequestBody User user){
        return testClient.findByUser(user);
    }
}
