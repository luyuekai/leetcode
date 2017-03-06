/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author 卢跃凯
 */
public class Solution9 {

//    public boolean isPalindrome(int x) {
//        if (x==0) {
//            return true;
//        }else if (x<0) {
//            return false;
//        }else{
//            StringBuffer tmp = new StringBuffer(x+"");
//            tmp = tmp.reverse();
//            if ((tmp.toString()).equals(x+"")) {
//                return true;
//            }
//        }
//        return false;
//    }
    public boolean isPalindrome(int x) {
        if (x < 0 || (x != 0 && x % 10 == 0)) {
            return false;
        }
        int rev = 0;
        while (x > rev) {
            rev = rev * 10 + x % 10;
            x = x / 10;
        }
        return (x == rev || x == rev / 10);
    }

    public static void main(String[] args) {
        Solution9 solution9 = new Solution9();
        boolean result = solution9.isPalindrome(12344321);
        System.out.println(result);
    }

}
