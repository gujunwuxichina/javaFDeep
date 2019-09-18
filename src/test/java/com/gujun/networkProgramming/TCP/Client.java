package com.gujun.networkProgramming.TCP;

import org.junit.Test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;

public class Client {

    @Test
    public void test01() {
        try {
//          Socket socket=new Socket("127.0.0.1",3000);
            Socket socket=new Socket();
            SocketAddress socketAddress=new InetSocketAddress("127.0.0.1",3000);
            socket.connect(socketAddress,10000);       //设置超时时间
            BufferedReader bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            System.out.println(bufferedReader.readLine());
            bufferedReader.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
