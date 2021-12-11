package com.example.cla.util;

import org.springframework.context.ApplicationContext;

import java.util.Arrays;

public class SpringUtil {
    public static ApplicationContext applicationContext =null;
    public static void setApplicationContext(ApplicationContext ctx){
        SpringUtil.applicationContext=ctx;
    }
    public static void printBean(){
        String[] beanNames=applicationContext.getBeanDefinitionNames();
        Arrays.sort(beanNames);

    }
}
