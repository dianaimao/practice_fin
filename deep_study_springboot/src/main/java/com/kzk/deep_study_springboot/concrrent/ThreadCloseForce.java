package com.kzk.deep_study_springboot.concrrent;

public class ThreadCloseForce {
    Thread thread;
    Boolean flag=false;
    public  void execute(Runnable runnable){
         thread=new Thread(){
            @Override
            public void run() {
                Thread thread1=new Thread(runnable);
                thread1.setDaemon(true);
                thread1.start();
                try {
                    thread1.join();
                    flag=true;
                } catch (InterruptedException e) {
                    System.out.println("被打断了");
                }
            }
        };
        thread.start();
    }
    public void shutdown(long mills){
        Long timeEnd=System.currentTimeMillis();
        while (!flag){
            Long time=System.currentTimeMillis()-timeEnd;
            if (time>mills)
            {  thread.interrupt();
                System.out.println("超时"+Long.toString(time));
            break;}
        }
    }
    public static void main(String[] args) {
        ThreadCloseForce threadCloseForce=new ThreadCloseForce();
        Long timeStart=System.currentTimeMillis();
        threadCloseForce.execute(new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        threadCloseForce.shutdown(10000);

    }
}
