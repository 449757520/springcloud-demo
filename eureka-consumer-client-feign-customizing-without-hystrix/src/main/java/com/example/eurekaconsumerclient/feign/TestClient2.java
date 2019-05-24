package com.example.eurekaconsumerclient.feign;
import com.example.config.Configuration2;
import feign.Feign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Component
@FeignClient(name = "xxx",url = "http://localhost:8100/*",configuration = Configuration2.class,fallback = FeignClientFallback.class)
public interface TestClient2 {
    @RequestMapping(method = RequestMethod.GET,value = "/eureka/apps/{serviceName}")
    String findServiceInfoEurekaByServiceName(@PathVariable("serviceName")String serviceName);
}
