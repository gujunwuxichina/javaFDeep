package com.gujun.basicClass;

import java.math.BigDecimal;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/7/2 13:36
 * @Version 1.0
 **/
public class Arith {

    private static final int DEF_DIV_SCALE=2;

    private Arith() {
    }

    public static double add(double d1,double d2){
        BigDecimal b1=BigDecimal.valueOf(d1);
        BigDecimal b2=BigDecimal.valueOf(d2);
        return b1.add(b2).doubleValue();
    }

    public static double sub(double d1,double d2){
        BigDecimal b1=BigDecimal.valueOf(d1);
        BigDecimal b2=BigDecimal.valueOf(d2);
        return b1.subtract(b2).doubleValue();
    }

    public static double mul(double d1,double d2){
        BigDecimal b1=BigDecimal.valueOf(d1);
        BigDecimal b2=BigDecimal.valueOf(d2);
        return b1.multiply(b2).doubleValue();
    }

    public static double div(double d1,double d2){
        BigDecimal b1=BigDecimal.valueOf(d1);
        BigDecimal b2=BigDecimal.valueOf(d2);
        return b1.divide(b2,DEF_DIV_SCALE,BigDecimal.ROUND_HALF_UP).doubleValue();    //四舍五入
    }

}
