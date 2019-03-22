package com.example.eurekaconsumerclient.web;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
public class Testcontroller {
    @Autowired
    private RestTemplate rest;
    /**
     * 1.部分ribbon消费还是按照默认原则进行 code-bengin
     */
    @Autowired
    private LoadBalancerClient loadBalancerClient;
    /**
     * 测试方法 code-end
     * @return
     */
    @GetMapping("/test")
    public String test(){
        ServiceInstance serviceInstance = loadBalancerClient.choose("http://client-provider");
        //System.out.println(serviceInstance.getHost()+ ":"+serviceInstance.getPort()+" : "+serviceInstance.getServiceId());
        return "1";
    }

    @GetMapping("/movie/{name}")
    public String findById(@PathVariable("name")String name){
        return this.rest.getForObject("http://client-provider/test/"+name,String.class);
    }

}
