package com.xm.controller;

import com.xm.service.HelloService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {
    @Autowired
    HelloService helloService;

    @GetMapping("/hi")
    public String hi(String name){
        String msg = helloService.hiService(name);
        return msg;
    }


    @GetMapping("/")
    public String index(){
        return "service_ribbon------------>>>";
    }
}
