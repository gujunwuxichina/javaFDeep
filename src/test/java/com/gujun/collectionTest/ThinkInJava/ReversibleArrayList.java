package com.gujun.collectionTest.ThinkInJava;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/7/14 12:45
 * @Version 1.0
 **/
public class ReversibleArrayList<T> extends ArrayList<T> {

    public ReversibleArrayList(Collection<T> c) {
        super(c);
    }

    public Iterable<T> reversedIterable(){
        return new Iterable<T>() {
            @Override
            public Iterator<T> iterator() {
                return  new Iterator<T>() {
                    private int index=size()-1;
                    @Override
                    public boolean hasNext() {
                        return index>-1;
                    }
                    @Override
                    public T next() {
                        return  get(index--);
                    }
                    @Override
                    public void remove() {
                        //无
                    }
                };
            }
        };
    }

}
