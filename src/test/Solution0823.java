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
public class Solution0823 {
    
    public int MinAdjustmentCost(ArrayList<Integer> A,int target){
        if (A==null || A.size()==0) {
            return 0;
        }
        int max = getMax(A);
        
        int[][] costs = new int[A.size()][max+1];
        
        for (int i = 0; i < costs.length; i++) {
            for (int j = 1; j <= max; j++) {
                costs[i][j] = Integer.MAX_VALUE;
                
                if (i==0) {
                    // 对于数组中的第一个整数,我们假设它的范围是从1到max
                    costs[i][j] = Math.abs(j-A.get(i));
                }else{
                    //对于整数A.get(i),如果我们将它调整到j,那么最小的调整总代价取决于 Math.abs(j-A.get(i)) + cost[i-1][k]
                    // k的范围是 Math.max(1,j-target) 到 Math.min(j + target,max)
                    
                    for (int k = Math.max(1,j-target); k < Math.min(j + target,max); k++) {
                        costs[i][j] = Math.min(costs[i][j],Math.abs(j - A.get(i)) + costs[i - 1][k]);
                        
                    }
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (int i = 1; i < max; i++) {
            min = Math.min(min, costs[costs.length - 1][i]);
        }
        return min;
    }
    
    private int getMax(ArrayList<Integer> A){
        int max = A.get(0);
        for (int i = 1; i < A.size(); i++) {
            max = Math.max(max, A.get(i));
            
        }
        return max;
    }

}
