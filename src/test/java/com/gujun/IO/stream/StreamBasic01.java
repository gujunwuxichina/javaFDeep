package com.gujun.IO.stream;

import org.junit.Test;

import java.io.*;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/8/3 7:22
 * @Version 1.0
 **/
public class StreamBasic01 {

    //Java中把不同的输入/输出源抽象标书为"流",通过流的方法允许Java程序使用相同的方式访问不同输入/输出源；
    //流的分类：按照不同的分类方式，可以将流分成不同的类型；
    //1.输入流和输出流，输入/输出都是从程序运行所在内存的角度来划分的；
        //Java输入流主要由InputStream和Reader作为基类，输出则是OutputStream和Writer，都是抽象类；
    //2.字节流和字符流，它们所操作的数据单位不同，字节流操作的8位字节，字符流操作的是16位字符；
    //3.节点流和处理流：
        //可以从/向一个IO设备读/写数据的流为节点流，也被称为低级流；
        //处理流则是对已存在的流进行连接或封装，通过封装后的流来实现数据读/写操作，也被称为高级流或包装流；
        //使用处理流时，程序不会直接连接到实际的数据源，只要使用处理流，程序就可以采用完全相同的代码来访问不同的数据源；

    //InputStream、Reader
    //InputStream方法：
        //int read()，从输入流中读取单个字节，返回所读取的字节数据（字节数据转换为int）；
        //int read(byte[]),从输入流中最多读取字节数组长度个字节，并将读取的字节存入数组中，返回实际读取的字节数；
        //int read(byte[],int start,int len);
    //Reader方法：
        //int read()，读取单个字符，返回读取的字符数据（字符数据转化为int）；
        //int read(char[]);int read(char[],int,int);
    @Test
    public void test01() throws IOException {
        InputStream inputStream=new FileInputStream(new File("gj.txt"));
        byte[] bytes=new byte[512];
        int hasRead=0;
        while ((hasRead=inputStream.read(bytes))>0){
            System.out.println(hasRead);
            System.out.println(new String(bytes,0,hasRead,"utf-8"));
        }
        inputStream.close();
    }
    //使用了自动关闭资源try()语句；
    @Test
    public void test02(){
        try
        (
            Reader reader=new FileReader(new File("gj.txt"));
        ) {
            char[] chars=new char[32];
            int hasRead=0;
            while ((hasRead=reader.read(chars))>0){
                System.out.println(new String(chars,0,hasRead));
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    //InputStream和Reader移动指针的方法：
        //mark(int),在指针当前位置记录一个标记；
        //boolean markSupported(),判断此输入流是否支持mark()，即是否支持记录标记
        //reset(),将指针重写定位到上一次记录标记mark位置；
        //long skip(long),指针向前移到n个字节/字符；
    @Test
    public void test03(){
        try
        (
            Reader reader=new FileReader(new File("gj.txt"));
        ) {
            if(!reader.markSupported()){
                throw new IOException();
            }
            reader.skip(22);
            reader.mark(1);
            int hasRead=0;
            char[] chars=new char[10];
            for(int i=0;i<5;i++){
                hasRead=reader.read(chars);
                System.out.println(new String(chars,0,hasRead));
                reader.reset();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //OutputStream、Writer:
    //void write(int),将指定字节/字符输出到输出流，int可以是字节也可以是字符；
    //write(byte[]/char[]);write(byte[]/char[],int,int);
    //因为字符流直接以字符作为操作单位，所有可以用字符串来代替字符数组：
        //write(String),write(String,int,int);
    @Test
    public void test04(){
        try
        (
            InputStream inputStream=new FileInputStream(new File("gj.txt"));
            OutputStream outputStream=new FileOutputStream(new File("out.txt"));
        ) {
            int hasRead=0;
            byte[] bytes=new byte[256];
            while ((hasRead=inputStream.read(bytes))>0){
                outputStream.write(bytes,0,hasRead);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @Test
    public void test05(){
        try
        (
            Writer writer=new FileWriter(new File("out.txt"));
        ) {
            writer.write("gujun\r\n");  //字符串\r\n是windows的换行符，如果是Unix\Linux则是\n；
            writer.write("22\r\n");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
