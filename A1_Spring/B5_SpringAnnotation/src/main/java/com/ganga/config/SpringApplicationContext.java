package com.ganga.config;
/*

* Spring核心配置类
*
* */
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

// 使用@Configuration 定义Spring配置类
@Configuration
// 扫描组件
@ComponentScan("com.ganga")
// 导入其他子配置类
@Import({SpringDataSourceApplicationContext.class})
public class SpringApplicationContext {

}
