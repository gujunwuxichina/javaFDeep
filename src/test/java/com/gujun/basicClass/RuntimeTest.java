package com.gujun.basicClass;

import org.junit.Test;

import java.io.IOException;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/6/30 7:47
 * @Version 1.0
 **/
public class RuntimeTest {

    //Runtime类代表Java程序的运行时环境，每个Java程序都有一个与之对应的Runtime实例；
    //程序通过该实例与运行时环境相连；可以通过Runtime.getRuntime()获取与之关联的Runtime实例；
    @Test
    public void test01(){
        Runtime runtime=Runtime.getRuntime();
        System.out.println(runtime.availableProcessors());
        System.out.println(runtime.freeMemory());
        System.out.println(runtime.totalMemory());
        System.out.println(runtime.maxMemory());
    }

    //还可以单独启动一个进程来运行操作系统的命令；
    @Test
    public void test02() throws IOException {
        Runtime runtime=Runtime.getRuntime();
        runtime.exec("notepad.exe");
    }
}
