package com.gujun.networkProgramming;

import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class Basic02 {

    //URL对象代表统一资源定位器；通常URL由协议名、主机、端口、资源组成；
    //URI,其实例代表一个统一资源标识符；URI不能用于定位任何资源，唯一作用是解析，
    //URL则包含一个可打开到达该资源的输入流，可以将URL理解成URI的特例； ✳

    //URL提供了多个构造器，有了URL对象就可以访问URL定位的资源了：
    //方法：
    //String getFile()获取资源名；
    //String getHost()获取主机名；
    //String getPath()获取URL路径部分；
    //int getPort()端口；getProtocol()协议名；getQuery()获取URL的查询部分；
    //URLConnection openConnection(),URLConnection对象代表与URL所引用的远程对象的连接；
    //InputStream openStream(),打开与此URL的连接，并返回一个用于读取该URL资源的InputStream；

    @Test
    public void test01() throws IOException {
        URL url=new URL("https://dldir1.qq.com/weixin/Windows/WeChatSetup.exe");
        URLConnection urlConnection=url.openConnection();
        System.out.println(urlConnection instanceof HttpURLConnection);
        System.out.println(url.getFile());
        System.out.println(url.getHost());
        System.out.println(url.getPath());
        System.out.println(url.openConnection().getContentLength());    //大小
        InputStream inputStream=url.openStream();
        byte[] bytes=new byte[1024];
        int hasRead=0;
        RandomAccessFile randomAccessFile=new RandomAccessFile("d:/wx.exe","rw");
        long start=System.currentTimeMillis();
        while((hasRead=inputStream.read(bytes))!=-1){
            randomAccessFile.write(bytes,0,hasRead);
        }
        System.out.println("耗时:"+(System.currentTimeMillis()-start));
        inputStream.close();
        randomAccessFile.close();
    }

    //多线程下载
    public static void main(String[] args) throws IOException {
        DownUtil downUtil=new DownUtil("https://dldir1.qq.com/weixin/Windows/WeChatSetup.exe","d:/wx.exe",1);
        downUtil.downLoad();
        new Thread(()->{
            double rate=0;
            long start=System.currentTimeMillis();
            while ((rate=downUtil.getCompleteRate())<1){
                System.out.println("已下载:"+rate*100+"%");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("耗时:"+(System.currentTimeMillis()-start));
        }).start();
    }

}
