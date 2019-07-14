package com.gujun.collectionTest.ThinkInJava;

import java.util.Iterator;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/7/14 10:50
 * @Version 1.0
 **/
public class StringIterator {

    private String[] strs;

    public String[] getStrs() {
        return strs;
    }

    public StringIterator(String[] strs) {
        this.strs = strs;
    }

    public Iterator<String> iterator(){
        return new Iterator<String>() {
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

}
