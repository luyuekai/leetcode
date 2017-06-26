/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lintcode;

import java.util.concurrent.TimeUnit;

/**
 * lyk_explanation:This is a demo
 * @author lyk
 * @date   2017-4-28
 *
 */
public class StopThread {

    private static boolean stopRequested;

    public static void main(String[] args) throws InterruptedException {

        Thread backgroundThread = new Thread(new Runnable() {
            @Override
            public void run() {
                int i = 0;
                while (!stopRequested) {
                    i++;
//                    try {
//                        TimeUnit.SECONDS.sleep(3);
//                    } catch (InterruptedException e) {
//                        // TODO Auto-generated catch block
//                        e.printStackTrace();
//                    }
                    System.out.println(i);
                }
            }
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);

        stopRequested = true;

    }
}