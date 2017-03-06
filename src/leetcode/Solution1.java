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
public class Solution1 {

    public int[] twoSum(int[] nums, int target) {
        int[] a =new int[2];
        for (int i = 0; i < nums.length; i++) {
            for (int j = i+1; j < nums.length; j++) {
                if ((nums[i]+nums[j])==target) {
                    a[0] = i;
                    a[1] = j;
                    
                }
                
            }
            
        }
        return  a;

    }

}
