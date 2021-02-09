package com.atguigu.boot.config;

import com.atguigu.boot.bean.Pet;
import com.atguigu.boot.bean.User;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 1、配置类里面使用@Bean标注在方法上给容器注册组件，默认也是单实例的
 * 2、配置类本身也是组件
 * 3、proxyBeanMethods:代理bean的方法
 * Full(proxyBeanMethods = true)
 * Lite(proxyBeanMethods = false)
 * 组件依赖
 */
@Configuration(proxyBeanMethods = true)  //SpringBoot配置类 == 配置文件
public class MyConfig {

    /**
     * 外部无论对配置类中的这个组件注册方法调用多少次，获取到的还是之前注册到容器中的单实例对象
     */
    @Bean   //给容器添加组件。以方法名作为组件id，返回类型是组件类型。返回值是在容器中的实例
    public User user01(){
        User zhangsan = new User("zhangsan",18);
        //user组件依赖Pet组件
        zhangsan.setPet(tomcatPet());
        return zhangsan;
    }

    @Bean("tom")
    public Pet tomcatPet(){
        return new Pet("tomcat");
    }
}
