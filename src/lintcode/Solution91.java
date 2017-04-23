/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lintcode;

import java.util.ArrayList;

/**
 * lyk_explanation:This is a demo
 *
 * @author lyk
 * @date 2017-4-22
 *
 */
public class Solution91 {

    /**
     * @param A: An integer array.
     * @param target: An integer.
     */
    public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
        // write your code here
        int result = Integer.MAX_VALUE;
        int tmp = Integer.MAX_VALUE;
        int[][] dp = new int[A.size()][101];
        for (int i = 0; i < 100; i++) {
            dp[0][i] = Math.abs(i - A.get(0));
        }
        for (int i = 1; i < A.size(); i++) {

            for (int j = 0; j <= 100; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                int start = j - target > 0 ? (j - target) : 0;
                int end = j + target <= 100 ? (j + target) : 100;
                for (int k = start; k <= end; k++) {
                    tmp = dp[i - 1][k] + Math.abs(j - A.get(i));
                    dp[i][j] = Math.min(tmp, dp[i][j]);

                }

            }
        }
        for (int i = 0; i <= 100; i++) {
            result = Math.min(result, dp[A.size() - 1][i]);
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> A = new ArrayList<>(4);
        A.add(1);
        A.add(4);
//        A.add(2);
//        A.add(3);
        Solution91 s = new Solution91();
        int result = s.MinAdjustmentCost(A, 1);
        System.out.println(result);
//        System.out.println(Integer.MAX_VALUE);
    }
}
