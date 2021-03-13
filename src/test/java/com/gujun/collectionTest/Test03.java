package com.gujun.collectionTest;

import org.junit.Test;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;

/**
 * @ClassName: Test03
 * @Author GuJun
 * @Description:
 * @Date 2021年02月22日 21:04
 */
public class Test03 {

    private static Collection<String> collection=new HashSet<>();

    static {
        collection.add("gujun");
        collection.add("wuxi");
        collection.add("java");
    }

    @Test
    public void test01(){
        Iterator<String> iterator=collection.iterator();
        while(iterator.hasNext()){
            String s=iterator.next();
            System.out.println(s);
            if(s.equals("wuxi")){
                iterator.remove();
            }
        }
        System.out.println(collection);
    }

}
