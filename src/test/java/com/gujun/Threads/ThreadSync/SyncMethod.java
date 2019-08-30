package com.gujun.Threads.ThreadSync;

public class SyncMethod {
    public static void main(String[] args) {
        AccountWithSyncMethod account=new AccountWithSyncMethod("B10001",1500);
        new DrawThreadByMethod("小李",account,800).start();
        new DrawThreadByMethod("小王",account,900).start();
    }
}
