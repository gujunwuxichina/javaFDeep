package com.gujun.networkProgramming;

import org.junit.Test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.InetAddress;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.net.UnknownHostException;

public class Basic01 {

    //网络编程：
    //计算机网络中实现通信必须有一些约定，即通信协议；
    //通信协议负责对传输速率、传输代码、代码结构、传输控制、出错控制等制定标准；为了让两个节点之间进行通信，
    //必须在它们之间建立通信工具，使彼此之间能进行信息交换；

    //IP地址和端口号：
    //IP地址用于唯一标识网络中的一个通信实体；
    //IP地址是数字型的，是一个32位整数，分成4个8位二进制数，即每个是0`255的十进制整数；
    //一个通信实体可以有多个通信程序同时提供网络服务，还需端口；
    //端口是一个16位整数，0~65535，表示数据交给哪个通信程序处理；

    //InetAddress类代表IP地址；两个子类Inet4Address、Inet6Address；
    //InetAddress类没有提供构造器，提供静态方法来获取实例：
    //getByName(String host),根据主机名获取实例；
    //getByAddress(byte[] addr),根据原始IP地址来获取实例；
    //getLocalHost()获取本机IP地址对应的实例；
    //方法：
    //getCanonicalHostName(),获取此IP地址的全限定域名；
    //getHostAddress(),返回对应的IP地址字符串；
    //getHostName()，获取IP地址主机名；
    //isReachable(),测试该地址是否可达；
    @Test
    public void test01() throws IOException {
        System.out.println(InetAddress.getLocalHost().getHostAddress());    //本机ip
        InetAddress inetAddress=InetAddress.getByName("www.baidu.com");
        System.out.println(inetAddress.isReachable(2000));  //true
        System.out.println(inetAddress.getCanonicalHostName()); //183.232.231.174  百度多台服务器此值不确定
        System.out.println(inetAddress.getHostAddress());   //183.232.231.174
        System.out.println(inetAddress.getHostName());  //www.baidu.com
        for(byte b:inetAddress.getAddress()){
            System.out.println(b);
        }
    }

    @Test
    public void test02() throws UnknownHostException {
        InetAddress inetAddress=InetAddress.getByAddress(new byte[]{-73,-24,-25,-82});  //根据183.232.231.174 而来
        System.out.println(inetAddress.getCanonicalHostName());
        System.out.println(inetAddress.getHostName());
    }

    //URLDecoder、URLEncoder,用于字符串的转换；
    //在URL地址里包含非西欧字符时，系统就会将这些字符转换成特殊字符；上面的所谓转换就是普通字符串和这些特殊字符串的转换；
    //URLDecoder,static decode(String,String),将乱码特殊字符解码为指定字符串；
    //URLEncoder,static encode(String,String),将普通字符串转为特殊字符串；
    @Test
    public void test03() throws UnsupportedEncodingException {
        String s="java基础";
        System.out.println(URLEncoder.encode(s,"gbk"));
        System.out.println(URLDecoder.decode(URLEncoder.encode(s,"gbk"),"gbk"));
    }

}
