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
    //在使用处理流包装节点流关闭时，只需关闭处理流即可，系统会自动关闭包装的节点流；
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
    //转换流，InputStreamReader/OutputStreamReader分别将字节输入输出流转换为字符输入输出流；
    public static void main(String[] args) {
        try(
            //System.in代表标准输入，即键盘输入；该输入是个InputStream(字节流)，将其包装成字符流处理比较方便；
            InputStreamReader inputStreamReader=new InputStreamReader(System.in);
            //InputStreamReader处理普通字符输入依旧不方便，再将其包装成处理流——BufferedReader,利用其readLine()可以一次读取一行；
            BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
        ) {
            String line=null;
            while ((line=bufferedReader.readLine())!=null){
                if(line.equals("exit")){
                    System.exit(1);
                }
                System.out.println(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //推回输入流
    //PushBackInputStream，PushBackReader;
    //方法：
    //void unread(byte[]/char[][,int,int]),将一个字节/字符数组内容推回到缓冲区，从而允许重复读取刚刚的内容；
    //void unread(int0，将一个字节/字符内容推回到缓冲区，从而允许重复读取刚刚的内容；
    //这两个推回输入流都带有一个推回缓冲区，当调用unread()时，系统会把指定内容推回到缓冲区，而每次调用read()
    //总是先冲缓冲区读取，只有完成读取了缓冲区的内容后且读取的数组还没满时才会从输入流中读取；
    @Test
    public void test02(){
        try(
            //此处指定缓冲区大小为32(字符)，默认为1，若推回缓冲区的内容超出了缓冲区大小，则会抛出异常；
            PushbackReader pushbackReader=new PushbackReader(new FileReader(new File("gj.txt")),32);
        ) {
            char[] buff=new char[32];
            int hasRead=0;
            while ((hasRead=pushbackReader.read(buff))>0){
                System.out.println(new String(buff,0,hasRead));
                pushbackReader.unread(buff);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //重定向标准输入/输出：
    //System提供了三个静态方法：
    //setErr(PrintStream),重定向标准错误输出流；
    //setIn(InputStream)，重定向标准输入流；
    //setOut(PrintStream)，重定向标准输出流；
    @Test
    public void test03(){
        try(
            PrintStream printStream=new PrintStream(new FileOutputStream(new File("out.txt")));
        ) {
            System.setOut(printStream);
            System.out.println("hi gujun");
            System.out.println("22");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

}
