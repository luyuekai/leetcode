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
public class Solution136 {

    public int singleNumber(int[] nums) {
        int a = 0;
        for (int i = 0; i < nums.length;  i++) {
            a ^= nums[i];

        }
        return a;
    }

}
