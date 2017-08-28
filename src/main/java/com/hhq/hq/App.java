package com.hhq.hq;

import com.hhq.hq.HqSpringDI.Hello;
import com.hhq.hq.HqSpringDI.HqPerson;
import com.hhq.hq.HqSpringDI.HqSchool;
import com.hhq.hq.HqSpringDI.HqSpeak;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class App {

    public static  void main(String[] args){



        ApplicationContext context = null;
        Hello hello;
        HqSpeak speak;
        HqSchool school;


        //xml配置
        String xmlConfigPath = "classpath:/spring/applicationContext.xml";
        context = new ClassPathXmlApplicationContext(xmlConfigPath);
         hello = (Hello)context.getBean(Hello.class);
        hello.sayHello();

        speak = (HqSpeak)context.getBean(HqPerson.class);
        speak.speak("欢迎DI");

        school = (HqSchool) context.getBean(HqSchool.class);
        school.zhaoPin();

        //java配置
//        context = new AnnotationConfigApplicationContext(ApplicationJavaConfig.class);
//        hello = (Hello)context.getBean(Hello.class);
//        hello.sayHello();
//
//        speak = (HqSpeak)context.getBean(HqPerson.class);
//        speak.speak("JavaConfig_DI");
//
//        school = (HqSchool) context.getBean(HqSchool.class);
//        school.zhaoPin();


    }
}
