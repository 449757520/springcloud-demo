package com.example.eurekaconsumerclient.feign;
import com.example.eurekaconsumerclient.pojo.User;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

@Component
@FeignClient("client-provider")
public interface TestClient {
    //必须使用@RequestMapping,不能使用@GetMapping
    //@PathVariable 必须指定参数名称
    @RequestMapping(method = RequestMethod.GET,value = "/test/{name}")
    String test(@PathVariable("name") String name);
    @RequestMapping(method = RequestMethod.POST,value = "/test/")
    User findByUser(@RequestBody User user);
    /**
     * 错误写法
     * @param user User 对象(参数为复杂参数)
     * @return
     */
    @RequestMapping(method = RequestMethod.POST,value = "/test/")
    User findByUserTest(User user);
    /**
     * 正确写
     * @param id    User->id属性
     * @param username   User->username属性
     * @return
     */
    @RequestMapping(method = RequestMethod.GET,value = "/test/")
    User findByUser(@RequestParam("id") Long id,@RequestParam("username") String username);
}
