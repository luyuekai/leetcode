/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

/**
 * lyk_explanation:This is a demo
 * @author lyk
 * @date   2017-6-26
 *
 */
public class Tobinary {
    public static void numToBinary(int n){
        int[] bit = new int[32];
        for (int i = 0; i < 32; i++) {
            if (((n>>(i)) & 1) ==1) {
                bit[i]++;
            }
        }
        for (int c : bit) {
            System.out.print(c);
        }
    }
    public static void main(String[] args) {
        numToBinary(8);
        System.out.println("");
    }
}
