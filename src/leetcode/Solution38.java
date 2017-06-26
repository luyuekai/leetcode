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
 * @date 2017-6-12
 *
 */
public class Solution38 {

    public static String test(int n) {
        StringBuilder curr = new StringBuilder("1");
        StringBuilder prev;
        int count;
        char say;
        for (int i = 0; i < n; i++) {
            prev = curr;
            curr = new StringBuilder();
            count = 1;
            say = prev.charAt(0);
            for (int j = 1; j < prev.length(); j++) {
                if (prev.charAt(j) != say) {
                    curr.append(count).append(say);
                    count = 1;
                    say = prev.charAt(j);

                } else {
                    count++;
                }
            }
            curr.append(count).append(say);
        }
        return curr.toString();
    }
    
    public static void main(String[] args) {
        test(4);
    }

}
