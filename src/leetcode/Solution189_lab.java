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
 * @date 2017-6-26
 *
 */
public class Solution189_lab {

    public static void rotate1(int[] nums, int k) {
        if (k >= nums.length) {
            k = 0;
        } else {
            k = nums.length - 1 - k;

        }
        int[] tmp = new int[nums.length];
        for (int i = k + 1; i < nums.length; i++) {
            tmp[i - k - 1] = nums[i];

        }
        for (int i = 0; i < k + 1; i++) {
            tmp[i + nums.length - k - 1] = nums[i];

        }
        nums = tmp;
        for (int u : tmp) {
            System.out.print(" " + u);
        }

    }

    public static void  rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(nums, 0, nums.length - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, nums.length - 1);
    }

    public static void reverse(int[] nums, int start, int end) {
        while (start < end) {
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
            start++;
            end--;
        }
    }

    public static void main(String[] args) {
        int[] test = {-1};
        rotate(test, 2);
    }

}
