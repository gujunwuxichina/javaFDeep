package com.gujun.networkProgramming;

import java.io.IOException;
import java.io.InputStream;
import java.io.RandomAccessFile;
import java.net.MalformedURLException;
import java.net.URL;

public class DownThread extends Thread {

    private String path;

    private int startPos;

    private int partSize;

    private RandomAccessFile randomAccessFile;

    public int hasDown;

    public DownThread(String path, int startPos, int partSize, RandomAccessFile randomAccessFile) {
        this.path = path;
        this.startPos = startPos;
        this.partSize = partSize;
        this.randomAccessFile = randomAccessFile;
    }

    @Override
    public void run() {
        try {
            URL url=new URL(path);
            InputStream inputStream=url.openStream();
            inputStream.skip(startPos);
            byte[] bytes=new byte[1024];
            int hasRead=0;
            while (hasDown<partSize&&(hasRead=inputStream.read(bytes))!=-1){
                randomAccessFile.write(bytes,0,hasRead);
                hasDown+=hasRead;
            }
            inputStream.close();
            randomAccessFile.close();
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
