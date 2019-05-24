package com.example.eurekaconsumerclient;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class PreZuulFilter extends ZuulFilter {
    private static Logger logger = LoggerFactory.getLogger(PreZuulFilter.class);
    //类型
    @Override
    public String filterType() {
        return "pre";
    }
    //执行顺序
    @Override
    public int filterOrder() {
        return 1;
    }
    //是否使用过滤器
    @Override
    public boolean shouldFilter() {
        return true;
    }
    //Filter具体逻辑
    @Override
    public Object run() throws ZuulException {
        HttpServletRequest request = RequestContext.getCurrentContext().getRequest();
        logger.info("请求的host:"+request.getRemoteHost());
        return null;
    }
}
