package com.kzk.deep_study_springboot.concrrent;

public class Interp {
    public static void main(String[] args) {
        Thread thread=new Thread(){
            @Override
            public void run() {
                while (true){
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        };
        thread.start();
        thread.interrupt();
        System.out.println(thread.isInterrupted());
    }
}
