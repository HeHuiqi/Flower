package com.hhq.hq.web;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.hhq.hq.HqData.HqUser;
import com.hhq.hq.HqMapper.HqUserMapper;
import com.hhq.hq.HqService.HqUserServiceImp;
import com.hhq.hq.HqUtils.HqResponseEntity;
import com.hhq.hq.HqUtils.HqToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

//RESTFul风格的
@RestController

@RequestMapping(value = "/flower")
public class HqUserController {

//    @Resource
    @Autowired
    private HqUserServiceImp userServiceImp;

    @ResponseBody//会将返回的对象解析为json格式返回
    @RequestMapping(value = "/user",method = RequestMethod.GET)

    public HqUser getUserInfo(@RequestParam("userId") long userId){
        System.out.println("userId=="+userId);
        HqUser user = userServiceImp.getUserById(userId);
        return user;
    }

    @ResponseBody//会将返回的对象解析为json格式返回
    @RequestMapping(value = "/user",produces = "application/json; charset=utf-8",method = RequestMethod.POST)
    //@RequestBody会解析请求参数的值
    public HqUser addUserInfo(@RequestBody HqUser user){

        return user;
    }

    @ResponseBody//会将返回的对象解析为json格式返回
    @RequestMapping(value = "/register",method = RequestMethod.POST)
    //@RequestBody会将请求的json数据映射为对象
    public Map addUser(@RequestBody HqUser user){

        System.out.println("object->"+user.getClass());


        Map resultMap = new HashMap();
        resultMap.put("status","1");
        resultMap.put("id",user.getUserId());
        resultMap.put("name",user.getUsername());

        return resultMap;
    }


    @ResponseBody//会将返回的对象解析为json格式返回
    @RequestMapping(value = "/login",produces = "application/json; charset=utf-8",method = RequestMethod.POST)
    //@RequestBody会将请求的json数据映射为对象
    public HqResponseEntity userLogin(@RequestBody HqUser user){
        HqResponseEntity responseEntity = HqResponseEntity.ok();

        System.out.println("login===");
        System.out.println("user:"+user.getUserId()+","+user.getPassword());

        HqUser dbUser = getUserInfo(user.getUserId());

        if(dbUser.getUserId() == user.getUserId() && dbUser.getPassword().equals(user.getPassword())) {
            HqUser tokenUser = new HqUser();
            tokenUser.setUserId(user.getUserId());
            System.out.println("tokenUserId_=="+user.getUserId());
            //给用户jwt加密生成token
            String token = null;
            try {
                //设置token过期时间，毫秒
                token = HqToken.sign(tokenUser, 60L*1000 * 60 * 72);
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (JsonProcessingException e) {
                e.printStackTrace();
            }
            //封装成对象返回给客户端
            responseEntity.putDataValue("userId", tokenUser.getUserId());
            responseEntity.putDataValue("token", token);
            responseEntity.putDataValue("user", tokenUser);
        }
        else{
            responseEntity =  HqResponseEntity.customerError(1011,"用户名ID或密码错误");
        }

        return responseEntity;
    }


}
