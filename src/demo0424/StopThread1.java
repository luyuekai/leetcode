/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package demo0424;

import java.util.concurrent.TimeUnit;

/**
 * lyk_explanation:This is a demo
 * @author lyk
 * @date   2017-4-28
 *
 */
public class StopThread1 {

    private static boolean stopRequested;
    
    private static synchronized  void requeatStop(){
        stopRequested = true;
    }
    private static synchronized boolean stopRequested(){
        return stopRequested;
    }

    public static void main(String[] args) throws InterruptedException {

        Thread backgroundThread = new Thread(new Runnable() {

            @Override
            public void run() {
                int i = 0;
                while (!stopRequested()) {
                    i++;
                    System.out.println(""+i);
                }
            }
        });
        backgroundThread.start();

        TimeUnit.SECONDS.sleep(1);

//        stopRequested = true;
        requeatStop();

    }

}
