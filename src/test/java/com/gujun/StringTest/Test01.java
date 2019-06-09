package com.gujun.StringTest;

import org.junit.Test;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/6/9 10:03
 * @Version 1.0
 **/
public class Test01 {

    //关于字符串直接量，程序第一次使用某个字符串直接量时，会使用常量池来缓存该字符串，后面需要用到该字符串时，会直接
    //使用常量池中的；
    //常量池：指的是编译期被确定并保存在已编译的class文件中的数据，包括类、方法、接口中的常量；
    //当一个字符串由uoge字符串常量连接而成时，本身也是字符串常量；
    @Test
    public void test01(){
        String s1="gujun";
        String s2="gu"+"jun";
        System.out.println(s1==s2);
        System.out.println(System.identityHashCode(s1));
        System.out.println(System.identityHashCode(s2));
    }

}
