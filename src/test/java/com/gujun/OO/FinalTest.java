package com.gujun.OO;

import org.junit.Test;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/6/24 13:53
 * @Version 1.0
 **/
public class FinalTest {

    //final修饰符：
    //final既可以修饰成员变量，也可以修饰局部变量、形参；修饰的变量一旦被赋值就不能被改变；

    //final成员变量：
    //final修饰的成员变量必须由程序员显示指定初始值；
    //类变量，必须在声明时或静态代码块中指定初始值；
    //实例变量，必须在声明或非晶态代码块或构造器中指定初始值；
    //不要在初始化final修饰的变量前访问改变量；

    //final局部变量：
    //系统不会对局部变量进行初始化，必须显示指定；

    //final修饰基本类型变量和引用类型变量的区别：
    //对于基本类型不能重复赋值；对于引用类型，final只保证变量所引用的地址不改变，即一直引用同一个对象，但是该对象可以改变；

    //可执行"宏替换"的final变量：
    //对于一个变量，满足以下条件就不再是一个变量，而是一个直接量：
    //1.final修饰；2.定义时就指定了初始值；3.该初始值在编译阶段就能确定；
    //此时编译器会把程序中所有用到该变量的地方直接替换成该变量的值；
    @Test
    public void test01(){

        String s1="gujun";
        String s2="gu"+"jun";
        System.out.println(s1==s2); //true

        String s3="gu";
        String s4="jun";
        System.out.println(s1==s3+s4);  //false

        final String s5="gu";   //final修饰相当于在常量池中
        final String s6="jun";
        System.out.println(s1==s5+s6);  //true

    }

    //final方法
    //final修饰的方法不能被重写，如果不希望子类重写父类的方法，可以使用final修饰；
    //final修饰的方法仅仅是不能被重写，可以被重载；

    //final类
    //final修饰的类不可以有子类；

}
