package com.gujun.networkProgramming.TCP;

import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

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

}
