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
 * @date 2017-8-24
 *
 */
public class Solution643 {

    public double findMaxAverage(int[] nums, int k) {
        int[] sum = new int[nums.length];
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = sum[i-1]+ nums[i];
            
        }
        
        int tmp = sum[k-1];
        for (int i = k; i < sum.length; i++) {
            int t = sum[i] - sum[i-k];
            tmp = Math.max(t, tmp);
            
        }
        
        return tmp/((double)k);

    }

}
