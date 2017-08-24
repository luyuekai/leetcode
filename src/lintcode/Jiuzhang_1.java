/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package lintcode;

/**
 * lyk_explanation:This is a demo
 * @author lyk
 * @date   2017-8-24
 *
 */
public class Jiuzhang_1 {
    public double finadMaxAverage(int[] nums,int k){
        
        int n = nums.length;
        double l =Integer.MAX_VALUE;
        double r =Integer.MIN_VALUE;
        
        for (int i = 0; i < nums.length; i++) {
            l = Math.min(nums[i], l);
            r = Math.max(nums[i], r);
            
        }
        double[] sumNums = new double[n+1];
        sumNums[0] = 0;
        
        while(r-l>1e-6){
            //以二分法来找平均值,  一个数组的平均值满足 大于等于  数组最小值; 小于等于 数组最大值
            double mid = (l+r)/2; 
            for (int i = 0; i < n; i++) {
                // 构造s数组
                sumNums[i+1] = sumNums[i] + nums[i]-mid;
            }
            
            double preMin = 0;
            double sumMax = Integer.MIN_VALUE;
            
            for (int i = k; i <= n ; i++) {
                sumMax = Math.max(sumMax, sumNums[i]-preMin);
                preMin = Math.max(preMin, sumNums[i-k+1]);
            }
            
            if (sumMax>=0) {
                l = mid;
            }
            else{
                r = mid;
            }
        }
        
        
        
        
        
        
        return l;
    }

}
