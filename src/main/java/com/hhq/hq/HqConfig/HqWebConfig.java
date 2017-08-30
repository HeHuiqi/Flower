package com.hhq.hq.HqConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc // 启用SpringMVC
@ComponentScan(basePackages = "com.hhq.hq.web") // 启用组件扫描
public class HqWebConfig extends WebMvcConfigurerAdapter{


//    public static void main(String[] args) {
//        SpringApplication.run(HqWebConfig.class, args);
//    }

    /** 视图解析器 */
    @Bean
    public ViewResolver viewResolver(){

        InternalResourceViewResolver resolver = new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/"); // 运行时的目录结构
        resolver.setSuffix(".jsp");
        return resolver;
    }

    /** 配置静态资源的处理 */
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        HqInterceptor hqInterceptor = new HqInterceptor();
        registry.addInterceptor(hqInterceptor).addPathPatterns("/","/flower/home");

        HqUserTokenInterceptor userTokenInterceptor = new HqUserTokenInterceptor();

        InterceptorRegistration tokenRegistration = registry.addInterceptor(userTokenInterceptor);
        //设置不拦截的url
        tokenRegistration.excludePathPatterns("/flower/login","/flower/register","/");
//        //添加拦截的url
        tokenRegistration.addPathPatterns("/flower/*");

    }
}
