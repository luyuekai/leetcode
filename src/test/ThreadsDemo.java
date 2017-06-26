/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * lyk_explanation:This is a demo
 * @author lyk
 * @date   2017-4-27
 *
 */
public class ThreadsDemo {
    public static int n = 0;
    private static final int NTHREADS = 10;
 
    public static void main(String[] argv) throws InterruptedException {
        final AtomicInteger count = new AtomicInteger();
        final CountDownLatch cdl = new CountDownLatch(NTHREADS);
        for (int i = 0; i < NTHREADS; i++) {
            final int i2 = i;
            new Thread(new Runnable() {
                public void run() {
//                    try {
//                        Thread.sleep(10);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
 
                    System.out.println(i2 + " before, n is: " + n);
                    n += 1;
                    System.out.println(i2 + " after , n is: " + n);
                    count.incrementAndGet();
 
                    cdl.countDown();
                }
            }).start();
        }
 
        cdl.await();
        System.out.println("count is: " + count.get());
        System.out.println("fxxk, n is: " + n);
    }
}
