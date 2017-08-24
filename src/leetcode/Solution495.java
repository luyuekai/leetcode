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
 * @date 2017-8-24
 *
 */
public class Solution495 {

    public int findPoisonedDuration(int[] timeSeries, int duration) {
        
        if (timeSeries.length==0) {
            return 0;
        }
        
        int result = 0;
        for (int i = 0; i < timeSeries.length-1; i++) {
            int timeSery = timeSeries[i];
            if ((timeSery+duration)<= timeSeries[i+1]) {
                result+=duration;
            }else{
                int tmp = timeSeries[i+1] - timeSery;
                result+=tmp;
            }
        }

        return result+duration;
    }

}
