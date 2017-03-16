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
 * @date Feb 28, 2017
 *
 */
public class tmp {

    public int[] twoSum(int[] nums, int target) {
        int[] tmp = new int[nums.length];
        System.arraycopy(nums, 0, tmp, 0, nums.length);
        Arrays.sort(nums);
        int[] result = new int[2];
        int[] result2 = new int[2];
        int j = nums.length - 1;
        int i1 =0;
//        for (int i = 0; i < j; i++) {
        while(i1<j){
            if ((nums[i1] + nums[j]) > target) {
                j--;

            } else if ((nums[i1] + nums[j]) < target) {
                i1++;
            } else {
                result[0] = nums[i1];
                result[1] = nums[j];
                break;
            }

        }
        int count = 0;
        for (int i = 0; i < tmp.length; i++) {
            if ((tmp[i] == result[0]) && (count<1)) {
                result2[0] = i;
                count++;
            } else if (tmp[i] == result[1]) {
                result2[1] = i;

            }

        }

        return result2;
    }
    
    public static void main(String[] args) {
        tmp tmpTest = new tmp();
        int target =10;
        int[] nums ={2,5,5,11};
        System.out.println(tmpTest.twoSum(nums, target)[0]+" "+tmpTest.twoSum(nums, target)[1]);
    }

}
