package com.ganga.config;

/*
* spring核心配置类
* */

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan("com.ganga")
@Import({DataSourceApplicationContext.class})
public class SpringApplicationContext {

}
