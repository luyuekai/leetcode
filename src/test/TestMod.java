/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

/**
 * lyk_explanation:This is a demo
 * @author lyk
 * @date   2017-4-30
 *
 */
public class TestMod {
    
    public static  int getMod(int n, int m){
        return n & (m-1);
    }  
            
    public static void main(String[] args) {
        System.out.println(getMod(7, 15));
    }

}
