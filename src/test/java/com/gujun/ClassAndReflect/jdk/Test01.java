package com.gujun.ClassAndReflect.jdk;

import org.junit.Test;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/8/5 20:16
 * @Version 1.0
 **/
public class Test01 {

    //Proxy类、InvocationHandler接口，通过这类和接口可以生成JDK动态代理类或动态代理对象；
    //JDK动态代理只能为接口生成动态代理；
    //Proxy是所有动态代理类的父类；Proxy不仅可以生成动态代理类，也可以生成动态代理实例；
    //static Class<?> getProxyClass(ClassLoader,Interfaces),创建一个动态代理类所对应的Class对象；
    //static Object newProxyInstance(ClassLoader,Interfaces,InvocationHandler),创建动态代理实例，
    //执行代理对象的方法会被替换为InvocationHandler的invoke();
    @Test
    public void test01(){
        InvocationHandler invocationHandler=new MyInvocationHandler();
        Plane plane= (Plane) Proxy.newProxyInstance(Plane.class.getClassLoader(),new Class[]{Plane.class},invocationHandler);
        plane.fly();
    }

    //动态代理和AOP
    @Test
    public void test02(){
        BigPlaneInvocationHandler invocationHandler=new BigPlaneInvocationHandler();
        Plane plane=new BigPlane();
        invocationHandler.setObject(plane);
        Plane proxy= (Plane) Proxy.newProxyInstance(Plane.class.getClassLoader(),new Class[]{Plane.class},invocationHandler);
        proxy.fly();
    }

}
