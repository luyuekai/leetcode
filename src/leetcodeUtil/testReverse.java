/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodeUtil;

/**
 *
 * @author 卢跃凯
 */
public class testReverse {

    public String reverseString(String s) {
        char[] tmp = s.toCharArray();
        for (int i = 0; i < (tmp.length / 2); i++) {
            char u = tmp[i];
            tmp[i] = tmp[tmp.length - 1 - i];
            tmp[tmp.length - 1 - i] = u;

        }
        return String.valueOf(tmp);
    }

    public String reverseString2(String s) {
        char[] tmp = s.toCharArray();
        for (int i = (tmp.length - 1)>>1; i >= 0; i--) {
            char u = tmp[i];
            tmp[i] = tmp[tmp.length - 1 - i];
            tmp[tmp.length - 1 - i] = u;
        }
        return String.valueOf(tmp);
    }

    public static void main(String[] args) {
        testReverse tR = new testReverse();
        System.out.println(tR.reverseString("1"));
        System.out.println(tR.reverseString2("1234"));
    }

}
