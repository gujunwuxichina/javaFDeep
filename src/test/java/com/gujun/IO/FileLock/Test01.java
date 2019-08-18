package com.gujun.IO.FileLock;

import org.junit.Test;

import java.io.*;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

/**
 * @ClassName gu
 * @Description TODO
 * @Author GuJun
 * @Date 2019/8/18 13:41
 * @Version 1.0
 **/
public class Test01 {

    //文件锁控制文件的全部或部分字节的访问；
    //FileChannel提供的lock()/tryLock()可以获取文件锁FileLock对象，从而锁定文件；
    //lock()和tryLock()区别：
    //当lock()试图锁定文件时，若无法得到文件，程序将一直阻塞；
    //而tryLock()是尝试锁定文件，会立刻返回，如果获得则返回该文件锁，否则返回null;
    //如果FileLock只是想锁定文件的部分而不是全部，如下：
    //lock/tryLock(long position,long size ,boolean shared),shared表示是否是共享锁；可以通过isShared()来判断；
    //处理完文件后调用release()来释放锁；
    @Test
    public void test01(){
        try(
            FileChannel fileChannel=new FileOutputStream(new File("gj.txt")).getChannel();
        ) {
            FileLock fileLock=fileChannel.tryLock();
            Thread.sleep(20000);    //20秒内无法修改文件
            fileLock.release();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
