/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.util.Arrays;



/**
 *
 * @author 卢跃凯
 */
public class testArraysort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String[] str1 ={"aa","abc","acd","b","abcd","abbbbbb","A","B"};
        Arrays.sort(str1,String.CASE_INSENSITIVE_ORDER);
        for (String str11 : str1) {
            System.out.print(str11+"  ");
        }
        
    }
    
}
