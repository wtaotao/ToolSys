package com.nikki.sample;

public class VolatileTest {


    public volatile int inc = 0;

    public synchronized void increase() {
        inc++;
    }

    public static void main(String[] args) throws InterruptedException {
        final VolatileTest test = new VolatileTest();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++)
                    test.increase();
            }).start();
        }
        //保证前面的线程都执行完
        Thread.sleep(3000);
        System.out.println(test.inc);
    }

}
