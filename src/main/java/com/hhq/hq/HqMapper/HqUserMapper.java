package com.hhq.hq.HqMapper;

import com.hhq.hq.HqData.HqUser;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public interface HqUserMapper {

    public HqUser findUser(long userId);

}
