/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 * lyk_explanation:This is a demo
 *
 * @author lyk
 * @date 2017-6-21
 *
 */
public class Solution58 {

    public static int lengthOfLastWord(String s) {
        int count = 0;
        s= s.trim();
        for (int i = s.length()-1; i >= 0; i--) {
            if (s.charAt(i)!=' ') {
                count++;
            }else{
                return count;
            }
        }
        return count;

    }
    
    public static void main(String[] args) {
        System.out.println(lengthOfLastWord("hello world"));
    }

}
