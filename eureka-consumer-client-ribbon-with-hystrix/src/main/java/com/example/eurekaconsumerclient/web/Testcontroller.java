package com.example.eurekaconsumerclient.web;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
@RestController
public class Testcontroller {
    //返回值和参数必须一致
    @Autowired
    @SuppressWarnings("all")   //关闭所有警告
    private RestTemplate restTemplate;
    @GetMapping("/movie/{name}")
    @HystrixCommand(fallbackMethod = "findByIdFallback")   //添加短路器
    
    public String findById(@PathVariable("name")String name){
        return this.restTemplate.getForObject("http://client-provider/test/"+name,String.class);
    }

    /**
     * 当请求时间超过规定时间之后就将走Fallback方法
     * @param name
     * @return
     */
    public String findByIdFallback(String name){
        return "出现异常";
    }
}
