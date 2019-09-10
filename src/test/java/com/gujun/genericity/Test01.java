package com.gujun.genericity;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/7/22 20:16
 * @Version 1.0
 **/
public class Test01 {

    //深入泛型：
    //1.定义泛型接口、类：可以为任何类、接口增加泛型声明，并不是只有集合才有；
    @Test
    public void test01(){
        Apple<String> apple1=new Apple<>("apple");
        System.out.println(apple1.getT());
        Apple<Integer> apple2=new Apple<>(22);
        System.out.println(apple2.getT());
    }
    //2.从泛型类派生子类：
    //当创建了带泛型声明的接口、父类之后，为接口创建实现类或从父类派生子类时，
    //使用接口、父类时不能再包含泛型声明；如：
    //A extends O<T>{...}是错误的；
    //因为使用接口、父类时就必须为类型形参传入实际的类型；如：
    //A extends O<String>{...}是正确的；也可以不传入实现类型（此时虚拟机会把类型形参当成Object）；

    //并不存在泛型类
    @Test
    public void test02(){
        List<String> list1=new ArrayList<>();
        List<Integer> list2=new ArrayList<>();
        System.out.println(list1.getClass()==list2.getClass()); //true
        //依然被当成同一个类，在内存中占用同一块内存；
        //因此在静态方法、静态初始化块或静态成员成员和初始化中不能使用类型形参；✳
        //由于系统中并不会真正生成泛型类，所以instanceof后不能使用泛型类；
    }

}
