/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

import java.util.ArrayList;

/**
 * lyk_explanation:This is a demo
 * @author lyk
 * @date   2017-8-23
 *
 */
public class Solution0823_1 {
  public int MinAdjustmentCost(ArrayList<Integer> A, int target) {
    int [][] dp = new int [A.size()+1][101];
    int len = A.size();

    for(int j = 1; j <= 100; j ++) {
      dp[0][j] = Math.abs(A.get(0) - j);
    }

    for(int i = 1; i < len; i ++) {
      for(int j = 1; j <= 100; j ++) {

        dp[i][j] = Integer.MAX_VALUE;
        for(int k = 0; k <= target; k ++) {
          int tmp = Integer.MAX_VALUE;


          if(j + k <= 100) {
            tmp = dp[i - 1][j + k] + Math.abs(j - A.get(i));
          }
          if(j - k >= 1) {
            tmp = Math.min(tmp, dp[i-1][j-k] + Math.abs(j - A.get(i)));
          }
          dp[i][j] = Math.min(tmp, dp[i][j]);

        }
      }
    }

    int ret = Integer.MAX_VALUE;

    for(int i = 1; i <= 100; i ++) {
      ret = Math.min(dp[len-1][i], ret);
    }

    return ret;
  }

}
