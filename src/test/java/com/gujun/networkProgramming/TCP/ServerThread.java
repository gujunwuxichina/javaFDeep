package com.gujun.networkProgramming.TCP;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class ServerThread implements Runnable {
    private Socket socket=null;
    private BufferedReader bufferedReader=null;

    public ServerThread(Socket socket) throws IOException {
        this.socket = socket;
        bufferedReader=new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run() {
        try {
            String content=null;
            while ((content=readFromClient())!=null){
                for(Socket s:Server.sockets){
                    PrintStream ps=new PrintStream(s.getOutputStream());
                    ps.println(content);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String readFromClient(){
        try {
            return bufferedReader.readLine();
        } catch (IOException e) {
            Server.sockets.remove(socket);
            e.printStackTrace();
        }
        return null;
    }

}
