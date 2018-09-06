package com.xm.controller;

import com.xm.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    HelloService helloService;

    @GetMapping("hi")
    public String hello(String name){
        String s = helloService.helloFeign(name + "-feign");
        return s;
    }

    @GetMapping("/")
    public String index(String name){
        return "service-----------feign";
    }


}
