package com.hhq.hq.HqService;

import com.hhq.hq.HqData.HqUser;
import com.hhq.hq.HqMapper.HqUserMapper;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service(value = "userService" )
public class HqUserServiceImp implements HqUserService{

    @Autowired
    private SqlSessionTemplate sqlSession;

    //此注解会自动获取userMapper实例
//    @Resource
    @Autowired //与上面等效
    private HqUserMapper userMapper;

    @Override
    public HqUser getUserById(long userId) {
        //通过SqlSessionTemplate 对象获取mapper实例
        //userMapper = sqlSession.getMapper(HqUserMapper.class);

        System.out.println("userMapper"+userMapper);
        return userMapper.findUser(userId);
    }
}
