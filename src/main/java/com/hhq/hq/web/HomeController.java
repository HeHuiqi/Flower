package com.hhq.hq.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/mvc")
public class HomeController {

    @RequestMapping("/home")
    public String hello(){
        return "home";
    }
}
