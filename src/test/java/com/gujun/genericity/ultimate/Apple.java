package com.gujun.genericity.ultimate;

/**
 * @ClassName: Apple
 * @Author GuJun
 * @Description:
 * @Date 2021年11月09日 19:46
 */
public class Apple<T> {

    private T t;

    public Apple() {
    }

    public Apple(T t) {
        this.t = t;
    }

    public T getT() {
        return t;
    }

    public void setT(T t) {
        this.t = t;
    }

    @Override
    public String toString() {
        return "Apple{" +
                "t=" + t +
                '}';
    }
}
