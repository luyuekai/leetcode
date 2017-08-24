/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package leetcode;

import java.util.Arrays;

/**
 * lyk_explanation:This is a demo
 * @author lyk
 * @date   2017-8-24
 *
 */
public class Solution621 {
    public int leastInterval(char[] tasks,int n){
        int[] c = new int[26];
        for (char t : tasks) {
            c[t - 'A']++;
            
        }
        Arrays.sort(c);
        int i = 25;
        while (i>=0 && c[i]==c[25]) {            
            i--;
        }
        
        return Math.max(tasks.length, (c[25]-1)*(n-1)+ 25-i);
    }

}
