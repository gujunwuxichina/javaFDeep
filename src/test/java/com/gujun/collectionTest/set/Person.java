package com.gujun.collectionTest.set;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/7/7 19:47
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

    public Person(String name, String cardNo) {
        this.name = name;
        this.cardNo = cardNo;
    }

//    @Override
//    public int hashCode() {
//        return this.name.hashCode()*19+this.cardNo.hashCode()*31;
//    }
//
//    @Override
//    public boolean equals(Object obj) {
//    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Person person = (Person) o;

        if (name != null ? !name.equals(person.name) : person.name != null) return false;
        return cardNo != null ? cardNo.equals(person.cardNo) : person.cardNo == null;
    }

    @Override
    public int hashCode() {
        System.out.println("调用hashCode()");
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (cardNo != null ? cardNo.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", cardNo='" + cardNo + '\'' +
                '}';
    }
}
