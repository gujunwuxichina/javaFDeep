package com.gujun.networkProgramming.TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClientThread implements Runnable {

    private Socket socket;

    private BufferedReader bufferedReader=null;

    public ClientThread(Socket socket) throws IOException {
        this.socket = socket;
        this.bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run() {
        try {
            String content=null;
            while ((content=bufferedReader.readLine())!=null){
                System.out.println(content);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
