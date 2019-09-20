package com.gujun.networkProgramming.TCP;

public class Basic01 {

    /*
        TCP/IP协议是一种可靠的网络协议，在通信两端各建立一个Socket,在两端形成网络虚拟链路；
        两端的程序就可以通过虚拟链路进行通信；
        Java通过Socket对象代表两端的通信端口，通过Socket产生的IO流来进行网络通信；
     */

    //Java中能接收其它通信实体连接请求的类是ServerSocket，ServerSocket对象用于监听来自客户端的Socket连接，
    //若没有连接，则一直处于等待状态；
    //Socket accept(),若接收到一个客户端Socket连接请求，该方法将返回一个与客户端Socket对应的Socket(每个TCP连接有两个Socket),
    //否则该方法一直等待，线程被阻塞；
    //创建ServerSocket的构造器：
    //ServerSocket(int port),指定端口创建；
    //ServerSocket(int port,int backlog),增加一个用来改变连接队列长度的参数backlog；？
    //ServerSocket(int port,int backlog,InetAddress ip),在机器存在多个IP的情况下,通过InetAddress参数将ServerSocket绑定到指定ip;
    //当ServerSocket使用完毕后，应该使用其close()来关闭该ServerSocket;通常情况下，服务端应该不断接收来自客户端的请求，所以会通过循环
    //来不断调用accept();

    //使用Socket进行通信：
    //客户端可以通过Socket的构造器来连接到指定服务器：
    //Socket(InetAddress/String remoteAddress,int port),创建连接到指定远程主机、远程端口的Socket,该构造器没有指定本地地址、本地端口，
    //默认使用本地主机的默认ip和系统动态分配的端口；
    //Socket(InetAddress/String remoteAddress,int port,InetAddress local,int localPort),创建连接到指定远程主机、远程端口的Socket,
    //并指定本地IP和端口；

    //当客户端、服务端产生了对应的Socket后，就无须再区分服务端和客户端了，通过各自的Socket进行通信；
    //getInputStream(),getOutputStream();


    //加入多线程：
    //实际的客户端需要与服务端保持长时间的通信；
    //服务端应该为每个Socket单独启动一个线程，负责与一个客户端进行通信；
    //客户端读取服务端数据的线程同样会被阻塞，所以应该单独启动一个线程，专门负责读取服务端数据；


}
