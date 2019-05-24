package com.example.eurekaconsumerclient.feign;
import feign.hystrix.FallbackFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
@Component
public class HystrixClientFactory implements FallbackFactory<UserFeignClientWithFactory> {
    /**
     * fallbackFactory 是 fallback 的增强版
     */
    private static Logger logger = LoggerFactory.getLogger(HystrixClientFactory.class);
    @Override
    public UserFeignClientWithFactory create(Throwable throwable) {
        logger.info("fallback: reason was:"+throwable.getMessage());
        return new UserFeignClientWithFactory() {
            public String test(String name) {
                return "测试FeignClientFactory";
            }
        };
    }
}
