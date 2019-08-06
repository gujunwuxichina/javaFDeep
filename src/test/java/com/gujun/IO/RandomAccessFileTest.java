package com.gujun.IO;

import org.junit.Test;

import java.io.*;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/8/6 19:53
 * @Version 1.0
 **/
public class RandomAccessFileTest {

    //RandomAccessFile与普通输入/输出流不同的是，它支持随机访问，即可以直接跳转到文件的任意地方读取；
    //RandomAccessFile只能读写文件，不能读写其它IO节点；RandomAccessFile可以自由移动指针；指针起始位置0；
    //long getFilePointer()返回指针当前位置；void seek(long)将指针定位到指定位置；
    //RandomAccessFile有两个构造器，一个以String来指定文件，另一个以File来指定文件；还有可以指定另一个mode参数(String类型)：
    //r,以只读方式打开文件，若写入会报异常；
    //rw,以读写方式打开，若文件不存在会自动创建；
    //rws,相对于rw还要求对文件的内容和元数据的每个更新都同步写入到底层存储设备；?
    //rwd,相对于rws还要求对文件内容的每个更新都同步写入到底层存储设备；?
    @Test
    public void test01() {
        try(
            RandomAccessFile randomAccessFile=new RandomAccessFile(new File("gj.txt"),"rw");
        ) {
            System.out.println(randomAccessFile.getFilePointer());  //0
            randomAccessFile.seek(randomAccessFile.length());   //移到到文件末尾
            randomAccessFile.write("gujun".getBytes()); //在末尾追加
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //向指定文件的内容中间插入内容：
    //需要先把插入点后面的内容读入缓冲区，等把要插入的内容写入后，再缓冲区的内容追加在后面即可；
    @Test
    public void test02() throws IOException {
        File temp=File.createTempFile("temp",null); //创建临时文件；
        temp.deleteOnExit();
        try(
            RandomAccessFile randomAccessFile=new RandomAccessFile(new File("gj.txt"),"rw");
            InputStream inputStream=new FileInputStream(temp);
            OutputStream outputStream=new FileOutputStream(temp);
        ){
            long position=randomAccessFile.length()/2;
            randomAccessFile.seek(position);
            int hasRead=0;
            byte[] bytes=new byte[64];
            while ((hasRead=inputStream.read(bytes))>0){
                outputStream.write(bytes,0,hasRead);
            }
            randomAccessFile.seek(position);
            randomAccessFile.write("AAA插入的内容AAA".getBytes());
            while ((hasRead=inputStream.read(bytes))>0){
                outputStream.write(bytes,0,hasRead);
            }
        }
    }
}
