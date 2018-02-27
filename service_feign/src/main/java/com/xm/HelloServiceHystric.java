package com.xm;

import com.xm.service.HelloService;
import org.springframework.stereotype.Component;

/**
 * feign断路由
 */
@Component
public class HelloServiceHystric implements HelloService {

    @Override
    public String helloFeign(String name) {
        return "sorry "+name;
    }
}
