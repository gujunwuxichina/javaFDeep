package com.gujun.OO;

import org.junit.Test;

/**
 * @ClassName: TestInteger
 * @Author GuJun
 * @Description:
 * @Date 2021年02月14日 15:08
 */

public class TestInteger {

    @Test
    public void test01(){
        Integer i1=Integer.valueOf(22);
        Integer i2=Integer.valueOf(22);
        System.out.println(i1==i2);     //true
        Integer i3=new Integer(22);
        Integer i4=new Integer(22);
        System.out.println(i3==i4);     //false

        System.out.println(i1.hashCode());
        System.out.println(i2.hashCode());
        System.out.println(i3.hashCode());
        System.out.println(i4.hashCode());
    }

}
