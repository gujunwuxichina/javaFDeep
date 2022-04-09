package com.gujun.test;

import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName: TestAtomicInteger
 * @Author GuJun
 * @Description:
 * @Date 2022年03月23日 22:38
 */
public class TestAtomicInteger {

    @Test
    public void test01(){
        AtomicInteger atomicInteger=new AtomicInteger(0);
        System.out.println(atomicInteger.getAndIncrement());
        System.out.println(atomicInteger.get());
//        Collections collections=null;
//        List
    }

}
