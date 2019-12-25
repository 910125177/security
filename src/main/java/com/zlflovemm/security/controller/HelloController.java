package com.zlflovemm.security.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloController
 * @Description DOTO
 * @Author zhulinfeng
 * @Date 2019/12/24 10:42
 * @Version 1.0
 */

@RestController
public class HelloController {

    @RequestMapping("/hello")
    public String hello(){
        return "hello world";
    }

    @RequestMapping("/hello2")
    public String hello2(){
        return "hello adada";
    }

    @RequestMapping("/")
    public String hello3(){
        return " qazqeee";
    }
}
