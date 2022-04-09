package com.gujun.effectivejava.chapter1.builder;

import org.junit.Test;

/**
 * @ClassName: Test
 * @Author GuJun
 * @Description:
 * @Date 2021年12月05日 21:12
 */
public class Test01 {

    @Test
    public void test01(){
        Game game=new Game.Builder("刀塔","V社",0.0).adult(false).supportNet(true).build();
        System.out.println(game);
    }

}
