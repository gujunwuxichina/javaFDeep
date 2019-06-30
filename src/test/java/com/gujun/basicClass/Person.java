package com.gujun.basicClass;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/6/30 8:11
 * @Version 1.0
 **/
public class Person implements Cloneable{

    private  String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person(String name) {
        this.name = name;
    }

    public Person clone() throws CloneNotSupportedException {
        return (Person)super.clone();
    }

}
