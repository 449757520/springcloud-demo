package com.example.eurekaconsumerclient.feign;
import com.example.config.Configuration2;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Component
@FeignClient(name = "xxx",url = "http://localhost:8081/*",configuration = Configuration2.class)
public interface TestClient2 {
    @RequestMapping(method = RequestMethod.GET,value = "/eureka/apps/{serviceName}")
    String findServiceInfoEurekaByServiceName(@PathVariable("serviceName")String serviceName);
}
