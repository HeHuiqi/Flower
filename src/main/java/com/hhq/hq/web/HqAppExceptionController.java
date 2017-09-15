package com.hhq.hq.web;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;
//这个类将会处理所有的异常情况
@ControllerAdvice
public class HqAppExceptionController {


    @ResponseBody
    @ExceptionHandler(Exception.class)
    public Map dealException(){

        Map deal = new HashMap();
        deal.put("status","0");
        deal.put("message","出错了");

        return deal;
    }
}
