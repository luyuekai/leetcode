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
 * @date 2017-4-6
 *
 */
public class Solution27 {

    public static int removeElement(int[] nums, int val) {
        int index = -1;
        int j = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == val) {
                j--;
                if (index < 0) {
                    index = i;

                }
            } else if (index >= 0) {
                nums[index] = nums[i];
                index++;
            }
        }
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println(j);
        return j;
    }

    public static void main(String[] args) {
        int[] num = {1, 2, 3, 3, 2, 3, 4, 5, 3, 3, 10,3, 6, 7};
        Solution27.removeElement(num, 3);
    }
//    public static int removeElement(int A[], int elem) {
//        int ex = -1;
//        int len = A.length;
//        for (int i = 0; i < A.length; i++) {
//            if (A[i] == elem) {
//                len--;
//                if (ex < 0) {
//                    ex = i;
//                }
//            } else if (ex >= 0) {
//                A[ex] = A[i];
//                ex++;
//            }
//        }
//        for (int B : A) {
//            System.out.print(B+" ");
//        }
//        return len;
//    }
//        public static void main(String[] args) {
//        int[] num = {1,2,3,3,3,4,5,3,3,3,6,7};
//        Solution27.removeElement(num, 3);
//        }

}
