package com.hhq.hq.HqConfig;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

@Configuration
@EnableWebMvc // 启用SpringMVC
@ComponentScan(basePackages = "com.hhq.hq.web") // 启用组件扫描
public class HqWebConfig extends WebMvcConfigurerAdapter{

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

    @Override
    public void addInterceptors(InterceptorRegistry registry) {


    }
}
