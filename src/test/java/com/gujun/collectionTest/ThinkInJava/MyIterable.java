package com.gujun.collectionTest.ThinkInJava;

import java.util.Iterator;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/7/14 12:30
 * @Version 1.0
 **/
public class MyIterable<String> implements Iterable {

    private String[] strs;

    public String[] getStrs() {
        return strs;
    }

    public MyIterable(String[] strs) {
        this.strs = strs;
    }

    @Override
    public Iterator iterator() {
        return new Iterator() {
            private  int index=0;
            @Override
            public boolean hasNext() {
                return index<strs.length;
            }
            @Override
            public Object next() {
                return strs[index++];
            }
            @Override
            public void remove() {
                //暂无
            }
        };
    }
}
