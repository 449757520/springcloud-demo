package com.example.eurekaconsumerclient.web;
import com.example.eurekaconsumerclient.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;

@RestController
public class Testcontroller {
    @Autowired
    private RestTemplate restTemplate;
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
    public String testClient(){
        /*ServiceInstance serviceInstance = loadBalancerClient.choose("http://client-provider");
        System.out.println(serviceInstance.getHost()+ ":"+serviceInstance.getPort()+" : "+serviceInstance.getServiceId());
        ServiceInstance serviceInstance2 = loadBalancerClient.choose("http://client-provider2");
        System.out.println(serviceInstance2.getHost()+ ":"+serviceInstance2.getPort()+" : "+serviceInstance2.getServiceId());*/
        return "1";
    }
    @GetMapping("/test-all")
    public List<User> listAll(){
        //错误写法 LinkedHashMap
       /* List<User> object = this.restTemplate.getForObject("http://client-provider:8082/list-all", List .class);
        for(User user:object){
            System.out.println(user.getId());
        }*/

        //正确写法
        User[] users = this.restTemplate.getForObject("http://client-provider:8082/list-all", User[] .class);
        List<User> userList = Arrays.asList(users);
        return userList;
    }



    @GetMapping("/movie/{name}")
    public String findById(@PathVariable("name")String name){
        return this.restTemplate.getForObject("http://client-provider/test/"+name,String.class);
    }

}
