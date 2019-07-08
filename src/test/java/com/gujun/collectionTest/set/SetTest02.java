package com.gujun.collectionTest.set;

import org.junit.Test;

import java.util.LinkedHashSet;
import java.util.Set;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/7/7 20:26
 * @Version 1.0
 **/
public class SetTest02 {

    //LinkedHashSet类，HashSet的子类，也是根据元素的hashCode值来决定元素的存储位置；
    //同时使用了链表来维护元素的次序，已插入顺序来保存；
    @Test
    public void test01(){
        Set<String> stringSet=new LinkedHashSet<>();
    }

}
