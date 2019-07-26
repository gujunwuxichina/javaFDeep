package com.gujun.genericity;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/7/26 16:03
 * @Version 1.0
 **/
public class Good {

    public <T> Good(T t) {
        System.out.println(t);
    }
}
