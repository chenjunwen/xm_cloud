package com.xm.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author chenjunwen
 */
@Api(description = "配置中心管理", tags = "配置中心")
@Controller
@RequestMapping("/config")
public class ConfigServerController {


    @ApiOperation(value = "开发环境配置", notes = "notes啊")
    @GetMapping("/dev")
    public String devConfig(){
        return "/xm-cloud/dev/master";
    }

    @ApiOperation(value = "生产环境配置",  notes = "notes啊")
    @GetMapping("/pro")
    public String proConfig(){
        return "/xm-cloud/pro/master";
    }

    @ApiOperation(value = "测试环境配置", notes = "notes啊")
    @GetMapping("/test")
    public String testConfig(){
        return "/xm-cloud/test/master";
    }

    @ApiOperation(value = "默认环境配置", notes = "notes啊")
    @GetMapping("/")
    public String config(){
        return "/xm-cloud/master";
    }
}
