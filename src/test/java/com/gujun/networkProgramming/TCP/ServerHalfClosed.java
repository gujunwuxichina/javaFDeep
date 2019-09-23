package com.gujun.networkProgramming.TCP;

import org.junit.Test;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class ServerHalfClosed {

    @Test
    public void test01() throws IOException {
        ServerSocket serverSocket=new ServerSocket(3000);
        Socket socket=serverSocket.accept();
        PrintStream printStream=new PrintStream(socket.getOutputStream());
        printStream.println("hi gujun");
        printStream.println("ni hao");
        socket.shutdownOutput();
        System.out.println(socket.isClosed());  //false
        Scanner scanner=new Scanner(socket.getInputStream());
        while (scanner.hasNextLine()){
            System.out.println(scanner.nextLine());
        }
        scanner.close();
        socket.close();
        serverSocket.close();
    }

}
