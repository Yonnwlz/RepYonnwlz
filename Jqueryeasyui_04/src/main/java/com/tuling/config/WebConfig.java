package com.tuling.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration      //创建一个xml
@MapperScan("com.tuling.dao")    //扫描mapper
public class WebConfig implements WebMvcConfigurer {
    //配置视图
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("layout").setViewName("layout");
        registry.addViewController("tabs").setViewName("tabs");
    }
}
