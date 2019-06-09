package com.gujun.se;

public enum Gender {

    MALE("男"),FEMALE("女");

    private final String name;

    private Gender(String name){
        this.name=name;
    }

    public String show(){
        return this.name;
    }

}
