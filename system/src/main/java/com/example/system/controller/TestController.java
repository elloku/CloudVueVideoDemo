package com.example.system.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author ：vivaciousis
 * @date ：Created in 2020/4/18 0:27
 * @description：
 */

@RestController
public class TestController {

    @RequestMapping("/test")
    public String test(){
        return "success";
    }
}
