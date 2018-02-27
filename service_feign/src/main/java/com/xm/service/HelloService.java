package com.xm.service;

import com.xm.HelloServiceHystric;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "eureka-client", fallback = HelloServiceHystric.class)
public interface HelloService {

    @GetMapping("hello")
    String helloFeign(@RequestParam(value = "name") String name);
}
