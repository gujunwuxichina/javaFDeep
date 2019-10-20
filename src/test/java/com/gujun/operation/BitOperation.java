package com.gujun.operation;

import org.junit.Test;

public class BitOperation {

    /*
        位运算符：
        Java支持7个位运算符：
            &与，两位同时为1才返回1；
            |或，只要有一位是1即返回1；
            ~非，取反；
            ^异或，相同返回0，不同返回1；
            <<，左移运算符；
            >>，右移运算符，左边空出来的以原来的符号位填充；
            >>>，无符号右移运算符，左边空出来以0填充；
     */

    @Test
    public void test01(){
        //Java int  32位 补码表示
        System.out.println(~22);    //-23
        System.out.println(11&22);  //2
        System.out.println(11|22);  //31
        System.out.println(11^22);  //29
    }

    @Test
    public void test02(){
        //<<左移运算符
        System.out.println(22<<2);  //88
        System.out.println(-10<<3); //-80
        //>>右移运算符
        System.out.println(14>>2);  //3
        System.out.println(-12>>2); //-3
        //>>>无符号
        System.out.println(-12>>>2);    //1073741821
    }

    //进行移位运算不会改变操作数本身，只是得到一个新的运算结果，原先的操作数本身是不会改变的；
    @Test
    public void test03(){
        Integer i1=22;
        System.out.println(System.identityHashCode(i1));
        System.out.println(System.identityHashCode(i1<<2));
        Integer i2=i1<<2;
        System.out.println(i2);
        System.out.println(System.identityHashCode(i1));
        System.out.println(System.identityHashCode(i2));
    }

}
