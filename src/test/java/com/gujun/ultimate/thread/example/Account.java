package com.gujun.ultimate.thread.example;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName: Account
 * @Author GuJun
 * @Description:
 * @Date 2021年08月11日 11:27
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = {"no"})
public class Account {

    private final ReentrantLock lock=new ReentrantLock();

    private String no;

    private Double balance;

    public synchronized void draw(double drawAmount){
        if(balance>=drawAmount){
            System.out.println(Thread.currentThread().getName()+"取钱成功:"+drawAmount);
            try {
                Thread.sleep(800*1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            balance-=drawAmount;
            System.out.println("余额:"+balance);
        }else{
            System.out.println(Thread.currentThread().getName()+"取钱失败,余额不足");
        }
    }

    public void drawLock(double drawAmount){
        lock.lock();
        try {
            if(balance>=drawAmount){
                System.out.println(Thread.currentThread().getName()+"取钱成功:"+drawAmount);
                try {
                    Thread.sleep(800*1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                balance-=drawAmount;
                System.out.println("余额:"+balance);
            }else{
                System.out.println(Thread.currentThread().getName()+"取钱失败,余额不足");
            }
        } finally {
            lock.unlock();
        }
    }

}
