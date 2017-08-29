package com.hhq.hq.HqConfig;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.hhq.hq",excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,value = EnableWebMvc.class)
})
public class HqRootConfig {
}
