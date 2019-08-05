package com.gujun.ClassAndReflect.reflect;

import org.junit.Test;

import java.lang.reflect.*;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/8/5 11:18
 * @Version 1.0
 **/
public class Basic01 {

    //通过反射查看类信息：
    //程序运行时，会出现编译时类型和运行时类型，有时会出现程序运行时接受一个外部对象，编译时类型为Object，此时该如何调用运行时类型的方法？
        //1.若知道运行时的类型，可以使用instancdOf先进行判断，在进行类型转换；
        //2.不知道运行时类型，只能依靠运行时信息来发现该对象和类型信息，即必须使用反射；

    //获得Class对象：
        //每个类被加载后，系统就会为其生成一个Class对象，通过该Class对象就可以访问到JVM中的这个类；获取Class对象的三种方式：
            //1.Class.forName(""),字符串参数是全限定类名；
            //2.通过类的class属性获取；
            //3.调用对象的getClass()
        //推荐第二种方法；
    //从Class中获取信息：
        //getConstructor(),getDeclaredConstructor();
        //getMethod(),getDeclaredMethod();
        //getName/SimpleName();
        //isArray(),isEnum(),isInstance(obj);

    //Executable抽象基类，代表可执行的类成员，派生了Constructor,Method两个子类；
        //int getParameterCount(),获取构造器或方法的形参个数；
        //Parameter[] getParameters(),获取该构造器或方法的形参； Parameter代表构造器和方法的参数；
            //Parameter方法：getName(),Class<?> getType(),getParameterizedType()获取带泛型的形参类型；
    @Test
    public void test01(){
        Class<Person> personClass=Person.class;
        Constructor[] constructors= personClass.getConstructors();
        for(Constructor constructor:constructors){
            System.out.println(constructor);
            System.out.println(constructor.getParameterCount());
        }
        Parameter[] parameters=constructors[1].getParameters();
        for(Parameter parameter:parameters){
            System.out.println(parameter);
            System.out.println(parameter.getName());
            System.out.println(parameter.getType());
        }
    }

    //使用反射生成并操作对象：
    //Method、Constructor、Field;
    //创建对象：Class对象的newInstance()是调用的默认构造器，若要通过指定构造器创建，可以先获取指定构造器对象，再调用其newInstance(...)；
    @Test
    public void test02() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Person person=Person.class.getConstructor(String.class,int.class).newInstance("gj",22);
        person.show();
    }
    //调用方法：
    //Method对象有个invoke(obj,...args),
    //当通过Method对象invoke()来调用方法时，必须要有调用该方法的权限；
    //若方法修饰符是private,先调用Method对象的setAccessible(boolean),true表示取消权限检查，false实施权限检查；
    @Test
    public void test03() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method=Person.class.getMethod("show");
        method.invoke(new Person("name",22));
    }
    //访问成员变量：
    //File，方法：
    //getXXX(obj)，获取obj对象的该成员变量值，XXX代表8种基本类型，若是引用类型，则去掉XXX;
    //setXXX(obj,val)，若是引用类型，则去掉XXX;
    @Test
    public void test04() throws NoSuchFieldException, IllegalAccessException {
        Person person=new Person("gujun",22);
        person.show();
        Field field=Person.class.getDeclaredField("name");
        field.setAccessible(true);
        System.out.println(field.get(person));
        field.set(person,"gj");
        person.show();
    }
    //操作数组：
    //java.lang.Reflect下有个Array类，代表所有数组，通过Array可以动态创建数组，操作数组元素等；
    //static Object newInstance(Class,int),创建一个具有指定的元素类型，长度的数组；
    //static T getXXX(array,index),返回数组中第index个元素，XXX是8种基本类型，若是引用则去掉XXX;
    //static void setXXX(array,index,val);
    @Test
    public void test05(){
        Object array=Array.newInstance(int.class,5);
        for(int i=0;i<5;i++){
            System.out.println(Array.getInt(array,i));
            Array.setInt(array,i,i);
        }
        System.out.println("===========================================");
        for(int i=0;i<5;i++){
            System.out.println(Array.getInt(array,i));
        }
    }

}
