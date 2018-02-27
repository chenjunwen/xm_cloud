package com.xm.service;

import com.netflix.discovery.converters.Auto;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class HelloService {
    @Autowired
    RestTemplate restTemplate;

    @HystrixCommand(fallbackMethod = "hiError")
    public String hiService(String name){
        String forObject = restTemplate.getForObject("http://eureka-client/hello?name="+name, String.class);
        return forObject;
    }


    public String hiError(String name){
        return "hi，"+name + ",sorry,error!";
    }
}
