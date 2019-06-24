package com.gujun.OO;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/6/24 13:26
 * @Version 1.0
 **/
public class Person {

    private String name;

    private String cardNo;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        return cardNo.equals(person.cardNo);
    }

    @Override
    public int hashCode() {
        return cardNo.hashCode();
    }
}
