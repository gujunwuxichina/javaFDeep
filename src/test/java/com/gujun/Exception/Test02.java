package com.gujun.Exception;

import org.junit.Test;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/7/28 8:27
 * @Version 1.0
 **/
public class Test02 {

    //Java异常分为Checked异常和Runtime异常；
    //所有的RuntimeException类及其子类的实例为Runtime异常；
    //其他为Checked异常；

    //只有Java提供了Checked异常，Checked异常必须被处理，否则编译无法通过；
    //Runtime异常则比较灵活，无须显示声明抛出，若程序需要捕获，也可以使用try-catch；

    //使用throws声明抛出异常：
    //若当前方法不知道如何处理异常，该异常交由上一级调用者处理，则使用throws抛出；
    //如果main()也不知道，也可以使用throws抛出，则异常交由JVM处理；
    //JVM处理方式是打印异常跟踪栈，并中止程序；
    //throws只能在方法签名中使用，可以抛出多个异常类，用,隔开；

    //使用throw抛出异常：
    //自行抛出异常使用throw;此时异常处理规则无任何差别；

    //自定义异常类：
    //一般情况下，程序很少会自行抛出(throw)系统系统；
    //因为异常的类名通常包含了该异常的有用信息；
    //所以应该选择合适的异常类，从而明确该异常信息；
    //自定义异常继承Exception，若是Runtime异常，继承RuntimeException；
    //有两个构造器：1.无参；2.带一个字符串参数，即getMessage()返回值；

    //catch和throw同时使用：
    //实际中，异常出现时，单靠某个方法无法完全处理，需要由几个方法协同处理；
    //可以在catch中结合使用throw;

    //Java7增强的throw语句：
    //Java编译器会只需更细致的检查，会检查throw抛出异常的实际类型；

    //异常链
    //不应该把底层的异常直接传给用户，应该先捕获原始异常，再抛出一个新的业务异常；
    //新的业务异常只包含了对用户的提示信息；
    //在JDK1.4以前，需要自己编写代码来保存原始异常信息，之后所有Throwable子类
    //的构造器都可以接收一个cause对象（即原始exception对象）作为参数，该cause表示原始异常；

    public static void test() throws MyCheckedException {
        try {
            String[] strs=new String[5];
            System.out.printf(strs[0]);
            System.out.printf(strs[5]);
        } catch (Exception e){
            System.out.printf(e.toString());    //Java编译器会只需更细致的检查，会检查throw抛出异常的实际类型
//            System.out.printf(e.getMessage());
            throw new MyCheckedException("自定义异常",e);
        }
    }

    @Test
    public void test01(){
        try {
            test();
        } catch (MyCheckedException e) {
            System.out.printf(e.getMessage());
//            e.printStackTrace();
        }
    }

}
