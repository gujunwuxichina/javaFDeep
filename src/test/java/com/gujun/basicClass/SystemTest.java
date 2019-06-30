package com.gujun.basicClass;

import org.junit.Test;

import java.util.Map;
import java.util.Properties;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/6/29 22:29
 * @Version 1.0
 **/
public class SystemTest {

    //java程序在不同的操作上运行时，可能需要取得平台相关的属性或调用平台命令来完成特定的功能；
    //System、Runtime类可以与平台进行交互；

    //System,程序不能创建System实例，System类提供了一些类变量和类方法；
    //提供了代表标准输入、输出、错误输出的类变量，一些静态方法用于访问环境变量、系统属性，还有加载文件和动态链接库的方法；
    @Test
    public void test01(){
        //获取系统所有的环境变量
        Map<String,String> map=System.getenv();
        for(String key:map.keySet()){
            System.out.println(key+":"+map.get(key));
        }
        //获取指定环境变量的值
        System.out.println(System.getenv("JAVA_HOME"));
        //获取所有系统属性
        Properties properties=System.getProperties();
        for(Object obj:properties.keySet()){
            System.out.println(obj.toString()+":"+properties.getProperty(obj.toString()));
        }
        //获取指定系统属性
        System.out.println(properties.getProperty("os.name"));
    }

    //currentTimeMillis()，返回一个long类型整数，毫秒数；
    //identityHashCode(obj),返回指定对象的精确hashCode值(即根据该对象地址计算得出的hashCode值)；
    //当某个类的hashCode()被重写后，实例的hashCode()就不能唯一标识对象；若两个对象的通过identityHashCode()返回值相同则说明为同一对象；
    @Test
    public void test02(){
        SystemTest s1=new SystemTest();
        SystemTest s2=s1;
        System.out.println(System.identityHashCode(s1));
        System.out.println(System.identityHashCode(s2));
    }

}
