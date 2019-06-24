package com.gujun.OO;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/6/24 16:34
 * @Version 1.0
 **/
public class People {

    private final Name name;

    public People(Name name) {
        this.name =new Name(name.getFirstName(),name.getLastName());
    }

    public Name getName() {
        return new Name(name.getFirstName(),name.getLastName());
    }
}
