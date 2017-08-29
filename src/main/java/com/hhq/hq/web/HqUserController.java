package com.hhq.hq.web;

import com.hhq.hq.HqData.HqUser;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

//RESTFul风格的
@RestController
@RequestMapping(value = "/flower")
public class HqUserController {


    @ResponseBody//会将返回的对象解析为json格式返回
    @RequestMapping(value = "/user",method = RequestMethod.GET)
    public HqUser getUserInfo(){

        HqUser user = new HqUser();
        user.setId(1);
        user.setUsername("小明");
        return user;
    }

    @ResponseBody//会将返回的对象解析为json格式返回
    @RequestMapping(value = "/user",method = RequestMethod.POST)
    //@RequestParam会解析请求参数的值
    public HqUser addUserInfo(@RequestParam("id") int id,@RequestParam("username") String name){

        HqUser user = new HqUser();
        user.setId(id);
        user.setUsername(name);
        return user;
    }

    @ResponseBody//会将返回的对象解析为json格式返回
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    //@RequestBody会将请求的json数据映射为对象
    public Map addUser(@RequestBody HqUser user){

        System.out.println("object->"+user.getClass());

        Map resultMap = new HashMap();
        resultMap.put("status","1");
        resultMap.put("id",user.getId());
        resultMap.put("name",user.getUsername());

        return resultMap;
    }

    @ResponseBody//会将返回的对象解析为json格式返回
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    //@RequestBody会将请求的json数据映射为对象
    public Map userLogin(@RequestBody HqUser user){

        System.out.println("object:"+user.getClass());

        Map resultMap = new HashMap();
        resultMap.put("status","1");
        resultMap.put("id",user.getId());
        resultMap.put("name",user.getUsername());

        return resultMap;
    }


}
