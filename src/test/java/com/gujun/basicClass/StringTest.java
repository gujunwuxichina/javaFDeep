package com.gujun.basicClass;

import org.junit.Test;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/7/1 20:57
 * @Version 1.0
 **/
public class StringTest {

    //字符串是一连串字符序列；
    //String是不可变类，一旦创建了一个String对象，包含在该对象中的字符序列就不可改变，直至该对象销毁；
    //StringBuffer对象代表一个可变的字符序列的字符串；该对象可以调用toString()将其转化为String对象；是线程安全的；
    //StringBuilder没有实现现场安全所以性能略高，优先考虑；

    //String类的构造器和方法：
    //构造器
    //String()，创建一个包含0个字符的对象，而不是返回null;
    //String(byte[] bytes,Charset charset/String charset),使用指定字符集将byte[]解码成一个String对象；
    //String(char[],...),将字符数组转化为String对象；
    //String(String original)，创建original的副本String对象；
    //String(StringBuilder/StringBuffer);
    //方法
    //char charAt(index)，int compareTo(String),String concat(String)，
    //boolean contentEquals(StringBuffer),static String copyValue(char[]),boolean endWith(String),
    //byte[] getBytes()，getChars(..char[]..),H

    //因为String是不可变类，会额外产生很多临时变量，使用StringBuilder/StringBuffer可以避免该问题；
    //StringBuilder/StringBuffer提供了一系列方法：
    //length，capacity属性，length是字符串序列长度，capacity是容量，通常比length大；
    //length的值可以改变，setLength(int)；
    //append()、insert()、reverse()等；

    @Test
    public void test01(){
        String s="+gujun";
        System.out.println(s.substring(1));
    }

}
