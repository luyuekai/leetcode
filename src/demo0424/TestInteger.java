/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package demo0424;

/**
 * lyk_explanation:This is a demo
 * @author lyk
 * @date   2017-4-26
 *
 */
public class TestInteger {
    public static void main(String[] args) {
        Integer i1 = new Integer(4);
        Integer i2 = new Integer(4);
        int s1 = i1;
        int s2 = i2;
        System.out.println(i1==i2);
        System.out.println(s1==s2);
        System.out.println(i1==s1);
    }

}
