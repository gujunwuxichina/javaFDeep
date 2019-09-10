package com.gujun.genericity;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/7/22 20:27
 * @Version 1.0
 **/
public class Apple<T> {

    private T t;

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    //构造器还是原来的类名，不需要增加泛型声明；调用构造器时还是要带<>；
    public Apple() {
    }

    public Apple(T t) {
        this.t = t;
    }
}
