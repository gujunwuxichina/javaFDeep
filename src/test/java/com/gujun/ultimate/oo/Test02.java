package com.gujun.ultimate.oo;

import org.junit.Test;

/**
 * @ClassName: Test02
 * @Author GuJun
 * @Description:
 * @Date 2021年06月28日 22:47
 */
public class Test02 {

    //  隐藏和封装
    //  访问控制符：
    //  private 同一类中
    //  default(默认)    同包下
    //  protected 同包下或不同包的子类
    //  public  公共访问，被所有类访问

    //  构造器 H
    class User{
        private String name;
        public User(String name) {
            System.out.println(this.name);  //  null
            this.name = name;
        }
    }
    @Test
    public void test01(){
        User user=new User("gujun");
    }


    //  类的继承
    //  如果父类的方法修饰符是private,则子类无法访问父类中的该方法，也就无法重写；

    //  多态
    //  引用变量有两个类型，一个编译时类型，一个是运行时类型；编译时类型由声明该变量时使用的类型决定，运行时类型由实际赋给该变量的对象决定；
    //  当编译时类型和运行时类型不一致时，就出现多态；

}
