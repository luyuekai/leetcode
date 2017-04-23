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
public class Solution26 {
      public int removeDuplicates(int[] nums) {
        int j = nums.length;
        int count = 1;
          if (j==1||j==0) {
              return j;
          }
          for (int i = 1; i < nums.length; i++) {
              if (nums[i]==nums[i-1]) {
                  j--;
              }else{
                  nums[count]=nums[i];
                  count++;
              }
              
          }
        return j;
    }
}
