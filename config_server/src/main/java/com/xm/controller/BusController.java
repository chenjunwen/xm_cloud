package com.xm.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@Api(tags = "消息总线事件、消息总线", description = "用于在集群（例如，配置变化事件）中传播状态变化，可与Spring Cloud Config联合实现热部署")
@RestController
public class BusController {

    @Autowired
    RestTemplate restTemplate;

    @ApiOperation(value = "热部署配置文件", notes = "其实就是请求curl -X POST http://127.0.0.1:9531/bus/refresh")
    @PutMapping("/busRefresh")
    public String busRefresh(){
        restTemplate.postForObject("http://127.0.0.1:9531/bus/refresh", "", String.class);
        return "刷新成功";
    }
}
