package com.example.eurekaconsumerclient.feign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Component
@FeignClient(name = "client-provider",fallbackFactory = HystrixClientFactory.class)
public interface UserFeignClientWithFactory {
    @RequestMapping(method = RequestMethod.GET,value = "/test/{name}")
    String test(@PathVariable("name") String name);
}
