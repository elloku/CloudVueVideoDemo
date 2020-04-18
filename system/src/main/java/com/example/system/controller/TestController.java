package com.example.system.controller;

import com.example.system.domain.Test;
import com.example.system.service.TestService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author ：vivaciousis
 * @date ：Created in 2020/4/18 0:27
 * @description：
 */

@RestController
public class TestController {

    @Resource
    private TestService testService;

    @RequestMapping("/test")
    public List<Test> test(){
        return testService.GetList();
    }
}
