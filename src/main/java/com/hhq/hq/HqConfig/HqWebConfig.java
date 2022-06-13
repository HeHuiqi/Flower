package com.hhq.hq.HqConfig;

//import com.mangofactory.swagger.configuration.SpringSwaggerConfig;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.*;
import org.springframework.web.servlet.view.InternalResourceViewResolver;
//@Configuration 注解表明是这个web应用的java配置，相当于webapp下的web.xml
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

    //注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        /*
        HqInterceptor hqInterceptor = new HqInterceptor();
        //添加拦截的url
        registry.addInterceptor(hqInterceptor).addPathPatterns("/","/flower/home");

<<<<<<< HEAD

=======
        // 添加拦截器，并设置拦截的url
>>>>>>> b2c3619 (update readme)
        HqUserTokenInterceptor userTokenInterceptor = new HqUserTokenInterceptor();
        InterceptorRegistration tokenRegistration = registry.addInterceptor(userTokenInterceptor);
        //设置不拦截的url
        tokenRegistration.excludePathPatterns("/flower/home","/flower/time","/flower/food","/flower/login","/flower/register","/");
        //添加拦截的url
        tokenRegistration.addPathPatterns("/flower/*");
        */
    }


    //添加静态资源位置
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

//         registry.addResourceHandler("/swagger/**").addResourceLocations("/WEB-INF/swagger/");
    }
}
