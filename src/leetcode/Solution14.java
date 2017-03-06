/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.Arrays;

/**
 *
 * @author 卢跃凯
 */
public class Solution14 {

    public String compareString(String str1, String str2) {
        int minLength = str1.length() < str2.length() ? str1.length() : str2.length();
        int index = 0;
        for (int i = 0; i <= minLength; i++) {
            if (str1.regionMatches(0, str2, 0, i) == true) {
                index = i;
            }
        }
        return str1.substring(0, index);

    }

    public String longestCommonPrefix3(String[] strs) {
        StringBuilder result = new StringBuilder();

        if (strs != null && strs.length > 0) {

            Arrays.sort(strs);

            char[] a = strs[0].toCharArray();
            char[] b = strs[strs.length - 1].toCharArray();

            for (int i = 0; i < a.length; i++) {
                if (b.length > i && b[i] == a[i]) {
                    result.append(b[i]);
                } else {
                    return result.toString();
                }
            }
            return result.toString();
        }
        return result.toString();
    }

    public String longestCommonPrefix2(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        } else if (strs.length == 0) {
            return "";
        }
        String result = strs[0];
        for (int i = 1; i < strs.length; i++) {
            result = compareString(result, strs[i]);

        }

        return result;
    }

    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 1) {
            return strs[0];
        }
        String[] allPrex = new String[strs.length];

        String onePrex = "";
        String twoPrex = "";
        String resultString = "";

        for (int i = 0; i < strs.length; i++) {
            for (int j = i + 1; j < strs.length; j++) {
                twoPrex = compareString(strs[i], strs[j]);
                if (twoPrex.length() > onePrex.length()) {
                    onePrex = twoPrex;
                }

            }
            allPrex[i] = onePrex;
        }

        for (int i = 0; i < allPrex.length; i++) {
            if (allPrex[i].length() > resultString.length()) {
                resultString = allPrex[i];
            }
        }
        return resultString;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Solution14 solution14 = new Solution14();
        String[] str = {"aaa", "b", "cccasdad", "acdads", "acdadfsf", "cccccc"};
        String result = solution14.longestCommonPrefix3(str);
        System.out.println(result);
    }

}
