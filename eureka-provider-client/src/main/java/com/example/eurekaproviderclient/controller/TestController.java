package com.example.eurekaproviderclient.controller;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;
import com.example.eurekaproviderclient.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
public class TestController {
    @Autowired
    @SuppressWarnings("all")     //抑制所有类型的警告
    private EurekaClient eurekaClient;
    @GetMapping("/eureka-instance")
    public String serviceUrl() {
        InstanceInfo instance = eurekaClient.getNextServerFromEureka("STORES", false);
        return instance.getHomePageUrl();
    }
    @GetMapping("/test/{name}")
    public String test(@PathVariable String name) {
        return "hello " + name;
    }
    @RequestMapping(method = RequestMethod.POST,value = "/test/")
    public User findByUser(@RequestBody User user){
        return user;
    }

    @RequestMapping(method = RequestMethod.GET,value = "/test/")
    public User findByUser(@RequestParam("id") Long id,@RequestParam("username") String username){
        User user = new User();
        user.setId(id);
        user.setUsername(username);
        return user;
    }
}

