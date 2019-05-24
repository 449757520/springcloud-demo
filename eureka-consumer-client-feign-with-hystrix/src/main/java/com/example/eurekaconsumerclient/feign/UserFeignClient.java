package com.example.eurekaconsumerclient.feign;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
@Component
@FeignClient(name = "client-provider",fallback = HystrixClientFallback.class)
public interface UserFeignClient {
    @RequestMapping(method = RequestMethod.GET,value = "/test/{name}")
    String test(@PathVariable("name") String name);
}
