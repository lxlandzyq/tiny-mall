package com.lxl.tiny.mall.modules.ums.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

//@Controller
//@RequestMapping("/test")
public class Cdemo {

    //@RequestMapping("/add")
    //@ResponseBody
    public String add(int a, int b){
        return String.valueOf(a+b);
    }

}
