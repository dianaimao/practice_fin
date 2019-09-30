package com.kzk.deep_study_springboot.concrrent;

public class synchTest {
    public static int i=9;
    public final static Object monit=new Object();
    public static void main(String[] args) {

        Runnable runnable=()->{
            synchronized (monit){
            while (i<500){
                System.out.println(Thread.currentThread().getName()+"----"+i);
                i++;
            }}
//            try {
//                Thread.sleep(10000);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }

        };
        Thread thread=new Thread(runnable,"11111");
        Thread thread1=new Thread(runnable,"222222");
        Thread thread2=new Thread(runnable,"3333333");
        thread.start();
        thread1.start();
        thread2.start();
    }
}
