package com.gujun.collectionTest.set;

import org.junit.Test;

import java.util.HashSet;
import java.util.Set;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/7/7 19:14
 * @Version 1.0
 **/
public class SetTest01 {

    //Set集合
    //不允许重复的元素，若将重复的元素加入，add()会返回false;

    //HashSet，是按照Hash算法来存储集合中的元素；
    //1不能保证元素的顺序，可以与添加相同，也可能不同；
    //2.不是同步的；
    //3.元素可以是null
    //当向HashSet中添加元素时，HashSet会调用该对象的hashCode()来得到hashCode值，根据该值决定对象在HashSet中的存储位置；
    //若两个元素的equal()返回true，但hashCode()不同，则会存储在不同位置，依旧添加成功；
    // 即若把一个对象放入HashSet中，应该重写其对应类的hashCode()和equal()保证一致；
    //HashSet判断两个元素相等的标准是两个对象通过equal()返回true，且他们的hashCode()返回也相等；
    //hashCode()的基本规则：
    //boolean,f?0:1;float,Float.floatToIntBits(f)；整数型（byte,short，char,int），（int)f;
    //double,先long l=Double.doubleoLongBits(f)，hashCode=(int)(1^(1>>>32));
    //long，hashCode=(int)(1^(1>>>32));引用类型hashCode=f.hashCode()；
    //当向HashSet中添加可变对象时，如果修改了对象，可能会导致该对象与集合中的其他对象相等，从而导致HashSet无法导致操作这些元素；

    @Test
    public void test01(){
        //当从HashSet中添加元素时，会计算该元素的hashCode值，即调用hashCode()；
        Set<Person> set=new HashSet<>();
        set.add(new Person("gj","001"));
        set.add(new Person("zhang","002"));

        set.forEach(p-> System.out.println(p));

    }

}
