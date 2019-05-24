package com.example.eurekaconsumerclient.web;
import com.example.eurekaconsumerclient.feign.TestClient;
import com.example.eurekaconsumerclient.feign.TestClient2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
@RestController
class TestController {
    @Autowired
    private TestClient testClient;
    @Autowired
    private TestClient2 testClient2;
    @GetMapping("/test/{name}")
    public String test(@PathVariable("name")String name){
        return testClient.test(name);
    }
    @RequestMapping(method = RequestMethod.GET,value = "/eureka/apps/{serviceName}")
    public String findServiceInfoEurekaByServiceName(@PathVariable("serviceName")String serviceName){
        return this.testClient2.findServiceInfoEurekaByServiceName(serviceName);
    }
}
