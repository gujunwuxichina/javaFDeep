package com.gujun.networkProgramming.TCP;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketAddress;

public class ClientHalfClosed {

    @Test
    public void test01() throws IOException {
        Socket socket=new Socket();
        SocketAddress socketAddress=new InetSocketAddress("127.0.0.1",3000);
        socket.connect(socketAddress,10000);       //设置超时时间
        BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
        String line=null;
        while ((line=bufferedReader.readLine())!=null){
            System.out.println(line);
        }
        PrintStream printStream=new PrintStream(socket.getOutputStream());
        printStream.println("半关闭Socket——客户端");
        bufferedReader.close();
        printStream.close();
        socket.close();
    }

}
