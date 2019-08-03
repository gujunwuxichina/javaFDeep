package com.gujun.IO.stream;

import org.junit.Test;

import java.io.*;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/8/3 21:50
 * @Version 1.0
 **/
public class StreamBasic02 {

    //处理流用法：
    //使用处理流来包装节点流，程序通过处理流来执行输入输出功能，让节点流与底层IO设备文件交互；
    @Test
    public void test01(){
        try(
            //使用PrintStream来包装OutputStream;
            //PrintStream输出功能非常强大，标准输出System.out的类型就是PrintStream;
            OutputStream outputStream=new FileOutputStream(new File("out.txt"));
            PrintStream ps=new PrintStream(outputStream);
        ) {
            ps.println("hello world");
            ps.println("gujun");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }



}
