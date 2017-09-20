package com.hhq.hq.HqService;

import com.hhq.hq.HqData.HqUser;
import com.hhq.hq.HqMapper.HqUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "userService" )
public class HqUserServiceImp implements HqUserService{

    @Resource
    private HqUserMapper userMapper;
    @Override
    public HqUser getUserById(int userId) {
        return userMapper.findUser(userId);
    }
}
