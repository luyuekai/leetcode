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
 * @date 2017-4-7
 *
 */
public class Solution28 {

    public static int strStr(String haystack, String needle) {

        if (needle == null) {
            return 0;

        }

        if (haystack == null) {
            return -1;

        }
        if (needle.equals("")) {
            return 0;
        }

        int index = -1;
        char[] s1 = haystack.toCharArray();
        char[] s2 = needle.toCharArray();
        for (int i = 0; i < s1.length; i++) {
            index = i;
            for (int j = 0; j < s2.length; j++) {
                
                if ((s1.length-i)<(s2.length)) {
                    return -1;
                }

                if (s1[index] == s2[j]) {
                    index++;
                    if (j == s2.length - 1) {
                        return i;
                    }
                    continue;
                } else {
                    break;
                }
            }
        }

        return -1;

    }

    public static void main(String[] args) {
        String str1 = "abaaaa";
        String str2 = "aaaa";
//        char[] tmp = str1.toCharArray();
//        System.out.println(tmp.length);
        System.out.println(Solution28.strStr(str1, str2));
    }

}
