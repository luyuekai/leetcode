/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

import java.util.ArrayList;
import java.util.List;

/**
 * lyk_explanation:This is a demo
 *
 * @author lyk
 * @date 2017-8-24
 *
 */
public class Solution442 {

    public static List<Integer> findDuplicates(int[] nums1) {
        int[] nums = nums1;
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i]) - 1;
            if (nums[index] < 0) {
                res.add(Math.abs(index + 1));
            }
            nums[index] = -nums[index];
        }
//        for (int i = 0; i < nums.length; i++) {
//            int num = nums[i];
//            System.out.print(" " + num);
//            System.out.println("");
//
//        }
        return res;
    }

    public static void main(String[] args) {
        int[] nums = {4, 3, 2, 7, 8, 2, 3, 1};
        findDuplicates(nums);

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            System.out.print(" " + num);

        }
    }

}
