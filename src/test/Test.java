/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author 卢跃凯
 */
public class Test {

    static int func(int x) {
        int countx = 0;
        while (x != 0) {
            countx++;
            x = x & (x - 1);
        }
        return countx;
    }
    public static void main(String[] args) {
        int result = Test.func(254);
        System.out.println(result);
    }
}
