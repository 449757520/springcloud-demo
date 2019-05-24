package com.example.eurekaconsumerclient.feign;

public class FeignClientFallback implements TestClient2{
    @Override
    public String findServiceInfoEurekaByServiceName(String serviceName) {
        return "haha";
    }
}
