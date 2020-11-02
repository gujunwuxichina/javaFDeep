package com.gujun.ClassAndReflect.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/8/5 20:44
 * @Version 1.0
 **/
public class BigPlaneInvocationHandler implements InvocationHandler {

    private Object target;

    public void setObject(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("起飞");
        Object result=method.invoke(target,args);
        System.out.println("降落");
        System.out.println(result);
        return result;
    }

}
