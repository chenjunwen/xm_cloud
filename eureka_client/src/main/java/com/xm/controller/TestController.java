package com.xm.controller;

import com.xm.EurekaClientApplication;
import com.xm.entity.DemoConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author chenjunwen
 */
@RestController
public class TestController {


    private final static Logger logger = LoggerFactory.getLogger(EurekaClientApplication.class);

    @Value("${server.port}")
    String port;

    @Autowired
    DemoConfig demoConfig;

    private AtomicInteger value = new AtomicInteger();


    @GetMapping("hello")
    public String hello(String name){

        String str = "hello "+name+",我的端口号="+port;
        return str;
    }

    @GetMapping("/")
    public String index(String name) throws InterruptedException {
        String str = "eureka——client我的端口号="+port;
        int i = value.incrementAndGet();
        logger.info("当前请求次数----"+i);
        TimeUnit.MILLISECONDS.sleep(100);
        return str;
    }

    @GetMapping("/configTest")
    public String configTest(){
        String title = demoConfig.getTitle();
        return "测试config--->"+title;
    }
}
