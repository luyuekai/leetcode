/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package collections;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * lyk_explanation:This is a demo
 * @author lyk
 * @date   2017-4-23
 *
 */
public class Demo {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(new Runnable() {

            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException ex) {
                    Logger.getLogger(Demo.class.getName()).log(Level.SEVERE, null, ex);
                }
                System.out.println("Hello");
            }
        });
        
        t.start();
        t.join();
        System.out.println("HTSC");
    }

}
