package com.gujun.IO.serializable;

import java.io.Serializable;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/8/11 8:29
 * @Version 1.0
 **/
public class Game implements Serializable {

    private static final long serialVersionUID = -4509992269742075123L;

    private String name;

    private double price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Game(String name, double price) {
        this.name = name;
        this.price = price;
    }

    public Game() {
    }

    @Override
    public String toString() {
        return "Game{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }

}
