package com.example.eurekaconsumerclient.feign;
import com.example.config.Configuration1;
import feign.Param;
import feign.RequestLine;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
@Component
@FeignClient(name = "client-provider", configuration = Configuration1.class)
public interface TestClient {
    @RequestLine("GET /test/{name}")
    String test(@Param(value = "name") String name);
}
