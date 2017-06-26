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
public class Solution35 {

    public static int searchInsert(int[] nums, int target) {

        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            int middle = (low + high) >> 1;
            if (target == nums[middle]) {
                return middle;
            } else if (target < nums[middle]) {
                high = middle - 1;
            } else {
                low = middle + 1;
            }

        }
        return low;

    }

    public static int searchInsert2(int[] nums, int target) {
        int low = 0;
        int high = nums.length - 1;
        if (low <= high) {
            int mid = (low + high) / 2;
            if (target == nums[mid]) {
                return mid;
            } else if (target < nums[mid]) {
            }
        }

        return 0;
    }

    public static int BinSearch(int Array[], int low, int high, int key) {
        if (low <= high) {
            int mid = (low + high) / 2;
            if (key == Array[mid]) {
                return mid;
            } else if (key < Array[mid]) //移动low和high  
            {
                return BinSearch(Array, low, mid - 1, key);
            } else if (key > Array[mid]) {
                return BinSearch(Array, mid + 1, high, key);
            }
        } else {
            return low;
        }
       return low;
    }

    public static void main(String[] args) {
        int[] a = {1, 3, 5, 6};
        int target = 7;
        System.out.println(searchInsert(a, target));
    }

}
