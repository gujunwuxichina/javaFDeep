package com.gujun.test;

import org.junit.Test;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/4/17 20:24
 * @Version 1.0
 **/
public class Test01 {

    @Test
    public void test01(){
        new TestClass();
    }

    @Test
    public void test02(){
        Integer integer=10;
        System.out.println(integer>0);
    }

    @Test
    public void test03(){
        String s="pageForAr";
        System.out.println(s.endsWith("Ar"));
    }

}
