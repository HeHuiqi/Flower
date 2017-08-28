package com.hhq.hq.HqConfig;

import com.hhq.hq.HqSpringDI.Hello;
import com.hhq.hq.HqSpringDI.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.web.context.WebApplicationContext;

@Configuration
public class ApplicationJavaConfig {

    @Bean
    public Hello getHello(){
        Hello hello = new Hello();
        hello.setName("小明");
        return hello;
    }

    //设置一个名字
    @Bean(name = "hqStudent")
    public HqStudent getStudent(){
        return  new HqStudent();
    }
    @Bean
    //指定作用域
    @Scope(value = WebApplicationContext.SCOPE_GLOBAL_SESSION,
            proxyMode = ScopedProxyMode.INTERFACES
    )
    public HqTeacher getTeacher(){
        return  new HqTeacher();
    }
    @Bean
    //自动传入，因为前面已经配置过bean了
    public HqPerson getPerson(HqStudent student){
        return  new HqPerson(student);
    }

    @Bean
    public HqSchool getSchool(HqTeacher teacher){
        HqSchool school = new HqSchool();
        school.setTeacher(teacher);
        return school;
    }
}
