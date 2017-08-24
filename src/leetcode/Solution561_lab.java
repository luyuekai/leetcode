/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.Arrays;

/**
 * lyk_explanation:This is a demo
 *
 * @author lyk
 * @date 2017-6-26
 *
 */
public class Solution561_lab {

    public static int arrayPairSum(int[] nums) {
        int sum = 0;
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            int a = nums[i];
            i++;
            int b = nums[i];
            sum += Math.min(a, b);

        }
        return sum;
    }
    
    public static void main(String[] args) {
        int[] test = {1,4,3,2};
        System.out.println(arrayPairSum(test));
    }

}
