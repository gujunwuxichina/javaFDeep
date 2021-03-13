package com.gujun.collectionTest;

import org.junit.Test;

import java.util.Arrays;
import java.util.Collection;
import java.util.stream.Stream;

/**
 * @ClassName: TestStream
 * @Author GuJun
 * @Description:
 * @Date 2021年02月22日 21:19
 */
public class TestStream {

    @Test
    public void test01(){
        Collection<Integer> collection= Arrays.asList(2,3,4,5,11,4,32,22,45,15,78,34,99,23);
        Stream<Integer> stream=collection.stream();
        System.out.println(stream.findAny().get());

        StringBuilder stringBuilder=new StringBuilder("gujun");
        System.out.println(stringBuilder.reverse().toString());
    }

}
