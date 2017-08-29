package com.hhq.hq.web;

import com.hhq.hq.HqData.HqUser;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

//RESTFul风格的
@RestController
@RequestMapping(value = "/flower")
public class HqUserController {


    @ResponseBody//会将返回的对象解析为json格式返回
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public HqUser getUserInfo(){

        HqUser user = new HqUser();
        user.setId(1);
        user.setName("小明");
        return user;
    }
}
