package com.lingkang.springsecuritymysql.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @author linke
 * @date 2019-11-16 下午 15:07
 * @description
 */
@Controller
public class WebController {

    @GetMapping(path = {"/", "/index"})
    public String index() {
        return "index";
    }

    @GetMapping("toLogin")
    public String toLogin() {
        return "login";
    }

    @GetMapping("/vip1/{id}")
    public String vip1(@PathVariable("id")String id){
        return "vip1/"+id;
    }

    @GetMapping("/vip2/{id}")
    public String vip2(@PathVariable("id")String id){
        return "vip2/"+id;
    }

    @GetMapping("/vip3/{id}")
    public String vip3(@PathVariable("id")String id){
        return "vip3/"+id;
    }
}
