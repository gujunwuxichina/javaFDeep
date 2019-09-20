package com.gujun.networkProgramming.TCP;

import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Server {

    protected static List<Socket> sockets= Collections.synchronizedList(new ArrayList<>());  //包装成线程安全的

    @Test
    public void test01() throws IOException {
        ServerSocket serverSocket=new ServerSocket(3000);
        while (true){
            Socket socket=serverSocket.accept();
            PrintStream printStream=new PrintStream(socket.getOutputStream());
            printStream.println("hi gujun");
            printStream.close();
            socket.close();
        }
    }

    //加入多线程的聊天室服务端
    @Test
    public void test02() throws IOException {
        ServerSocket serverSocket=new ServerSocket(3000);
        while (true){
            Socket socket=serverSocket.accept();
            sockets.add(socket);
            new Thread(new ServerThread(socket)).start();
        }
    }

}
