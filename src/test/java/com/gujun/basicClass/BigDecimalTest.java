package com.gujun.basicClass;

import org.junit.Test;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/7/2 13:24
 * @Version 1.0
 **/
public class BigDecimalTest {

    //float，double，基本类型的浮点数容易引起精度丢失：
    @Test
    public void test01(){
        System.out.println((0.05+0.01));    //精度丢失
    }
    //为此提供了BigDecimal类，该类提供了大量构造器将基本类型、字符串、数字字符数组来创建对象；
    //不推荐直接将浮点数作为构造器的参数，这样有不可预知性，如：0.1作为构造器参数，值并不是0.1,而是近似0.1；
    //推荐使用数字字符串作为构造器参数；如果必须通过浮点数参数来创建BigDecimal对象，则应该通过静态方法vlaueOf(double)来获取实例；
    @Test
    public void test02(){
        System.out.println(Arith.add(0.05,0.01)+"");    //0.06
        System.out.println(Arith.div(0.5,0.3));
    }

}
