package com.hhq.hq.HqConfig;


import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.mapper.MapperFactoryBean;
import org.mybatis.spring.mapper.MapperScannerConfigurer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import javax.sql.DataSource;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.hhq.hq",excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ANNOTATION,value = EnableWebMvc.class)
})
public class HqRootConfig {


    //数据源
    @Bean
    public DataSource getDataSource(){

        DriverManagerDataSource dataSource = new DriverManagerDataSource();
//        5.7
//        dataSource.setDriverClassName("com.mysql.jdbc.Driver");
//        8.0
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");

        dataSource.setUrl("jdbc:mysql://localhost:3306/study?useUnicode=true&characterEncoding=UTF-8");
        dataSource.setUsername("root");
        dataSource.setPassword("h12345678");
        return dataSource;
    }
    //事务管理
    @Bean
    public DataSourceTransactionManager dataSourceTransactionManager(DataSource dataSource){

        DataSourceTransactionManager dataSourceTransactionManager = new DataSourceTransactionManager();
        dataSourceTransactionManager.setDataSource(dataSource);
        return dataSourceTransactionManager;

    }


    @Bean(value = "SqlSessionFactoryBean")
    public SqlSessionFactoryBean getSqlSessionFactoryBean(DataSource dataSource){

        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(dataSource);
        Resource resource = new ClassPathResource("mybatis/mybatis-config.xml");
        sqlSessionFactoryBean.setConfigLocation(resource);

        return sqlSessionFactoryBean;
    }


//    Mapper接口所在包名，Spring会自动查找其下的Mapper
    @Bean
    public MapperScannerConfigurer getMapperScannerConfigurer(){

        MapperScannerConfigurer configurer = new MapperScannerConfigurer();

        configurer.setBasePackage("com.hhq.hq.HqMapper");
        configurer.setSqlSessionFactoryBeanName("SqlSessionFactoryBean");

        return configurer;

    }


    @Bean
    public SqlSessionTemplate getSqlSessionTemplate(DataSource dataSource){

        SqlSessionFactoryBean sqlSessionFactoryBean = getSqlSessionFactoryBean(dataSource);
        SqlSessionFactory sqlSessionFactory = null;
        try {
            sqlSessionFactory = sqlSessionFactoryBean.getObject();
        } catch (Exception e) {
            e.printStackTrace();
        }
        SqlSessionTemplate template = new SqlSessionTemplate(sqlSessionFactory, ExecutorType.REUSE);
        return template;
    }

}
