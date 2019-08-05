package com.gujun.ClassAndReflect.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/8/5 20:31
 * @Version 1.0
 **/
public class MyInvocationHandler implements InvocationHandler {

    //proxy动态代理对象，method 方法，args 方法参数；
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("代理方法");
        return null;
    }

}
