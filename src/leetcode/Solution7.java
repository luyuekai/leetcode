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
public class Solution7 {

    public int reverse(int x) {
        long x1 = x;
        long result = 0;
        if (x1 >= 0) {

            StringBuffer stringX = new StringBuffer(x1 + "");
            stringX = stringX.reverse();
            result = Long.parseLong(stringX.toString());
            result = result > Integer.MAX_VALUE ? 0 : result;
            return (int)result;

        } else {
            x1 = -x1;
            StringBuffer stringX = new StringBuffer(x1 + "");
            stringX = stringX.reverse();
            result = Long.parseLong(stringX.toString());
            result = -result< Integer.MIN_VALUE? 0 : -result;
            return (int)result;
        }
    }

    public static void main(String[] args) {
        Solution7 s = new Solution7();
        System.out.println(s.reverse(-2147483648));
    }
}
