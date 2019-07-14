package com.gujun.collectionTest.ThinkInJava;

import java.util.AbstractCollection;
import java.util.Iterator;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/7/14 10:38
 * @Version 1.0
 **/
public class MyCollection01<String> extends AbstractCollection {

    private String[] strs;

    public MyCollection01(String[] strs) {
        this.strs = strs;
    }

    @Override
    public Iterator<String> iterator() {
        return  new Iterator<String>() {
            private int index=0;
            @Override
            public boolean hasNext() {
                return index<strs.length;
            }
            @Override
            public String next() {
                return strs[index++];
            }
            @Override
            public void remove() {
                //先不实现，后有；
            }
        };
    }

    @Override
    public int size() {
        return strs.length;
    }
}
