package com.hhq.hq.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

@Controller
@RequestMapping(value = "/flower")
public class HomeController {

    @RequestMapping( value = "/home",method = RequestMethod.GET)
    public String hello(){
        return "home";
    }

    @RequestMapping(value = "/food",produces = "text/html;charset=utf-8",method = RequestMethod.GET)
    public void getFood(String name, HttpServletResponse response){

        response.setContentType("text/html;charset=utf-8");
        try {
            response.getWriter().println("食物："+name);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(value = "/time")
    public ModelAndView login(){

        System.out.println("time");
        ModelAndView model = new ModelAndView("time");
        model.addObject("time", new Date());
        model.getModel().put("name", "小花");
        return model;
    }

}

