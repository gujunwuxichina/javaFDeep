package com.gujun.enumTest;

import org.junit.Test;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/5/20 20:06
 * @Version 1.0
 **/
public class EnumTest {

    //某些情况下，一个类的对象是有限的——枚举类；
    //在早期的代码中，会使用静态常量来表示枚举；
    //在enum出现前，定义方式：
    //private来隐藏构造器；将类的所有实例都使用public static final修饰的变量来保存；提供静态方法来获取实例；

    //enum关键字：
    //1.使用enum定义的类默认继承Enum类，因此枚举类不能显示继承其他父类；
    //2.使用enum定义的、非抽象的枚举类默认使用final修饰，所以不能派生子类；
    //3.枚举类的构造器默认private修饰；
    //4.枚举类的所有实例，必须在枚举类的第一行显式列出；这些实例会自动添加public static final修饰；

    @Test
    public void test01(){
        //枚举类默认提供values()，可以方便遍历所有实例
        for(SeasonEnum seasonEnum:SeasonEnum.values()){
            System.out.println(seasonEnum);
        }
        //如果要使用枚举类的某个实例，可以通过使用EnumClass.variable的形式；
        System.out.println(SeasonEnum.SPRING.name());
        System.out.println(SeasonEnum.SPRING);
        System.out.println(SeasonEnum.SPRING.toString());
        //在switch case中case表达式中可以直接使用实例名字，无需枚举类前缀；

    }

    //枚举类都继承自Enum，可以使用Enum中的方法；
    //compareTo(E)，用于用类型的枚举实例间比较顺序；
    //name()，返回枚举实例的名字，该名称就是定义枚举类时列出的实例值；一般推荐toString()更好
    //ordinal()，返回索引，从0开始；
    //valueOf(Enum，name)，静态方法，用于返回指定枚举类中指定名称的枚举值；

    //枚举类的成员变量、方法和构造器；
    //枚举类应该设计成不可变类——即其成员变量不应该允许改变，用private final修饰；
    //此时就应该通过构造器为其进行初始化（也可以在定义时进行初始化或者在代码块中进行，推荐使用构造器）
    //一旦为枚举类显示定义了带参数的构造器，就必须在列出实例时传入参数；
    @Test
    public void test02(){
        System.out.println(Gender.MALE.show());
    }

}
