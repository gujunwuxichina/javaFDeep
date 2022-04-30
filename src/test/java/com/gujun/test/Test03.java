package com.gujun.test;

import com.gujun.ultimate.annotation.Test01;
import org.junit.Test;

/**
 * @ClassName: Test03
 * @Author GuJun
 * @Description:
 * @Date 2021年11月15日 16:37
 */
public class Test03 {

    public static void main(String[] args) {
        long start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 10000; j++) {
                if(i == j){
                    System.out.print(1);
                }
            }
        }
        long endTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 10000; j++) {
                if(j == i){
                    System.out.print(1);
                }
            }
        }
        long end2 = System.nanoTime();
        System.out.println();
        System.out.println(endTime - start);
        System.out.println(end2 - endTime);
    }

    @Test
    public void test01(){
        long start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 10000; j++) {
                if(i == j){
                    System.out.print(1);
                }
            }
        }
        long endTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 10000; j++) {
                if(j == i){
                    System.out.print(1);
                }
            }
        }
        long end2 = System.nanoTime();
        System.out.println();
        System.out.println(endTime - start);
        System.out.println(end2 - endTime);
    }

    @Test
    public void test02(){
        long start = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 10000; j++) {
                if(j == i){
                    System.out.print(1);
                }
            }
        }
        long endTime = System.nanoTime();
        for (int i = 0; i < 10000; i++) {
            for (int j = 0; j < 10000; j++) {
                if(i == j){
                    System.out.print(1);
                }
            }
        }
        long end2 = System.nanoTime();
        System.out.println();
        System.out.println(endTime - start);
        System.out.println(end2 - endTime);
    }

    @Test
    public void test03(){
        String s="0322";
        System.out.println(22+s);
    }

    @Test
    public void test04(){
        String s="2202201";
        System.out.println(s.substring(2));
    }

}
