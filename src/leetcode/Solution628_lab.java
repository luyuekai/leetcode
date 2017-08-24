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
 * @date 2017-6-28
 *
 */
public class Solution628_lab {

    public static int maximumProduct(int[] nums) {
        if (nums.length==3) {
            return nums[0]*nums[1]*nums[2];
        }
        int max1 = 0;
        int max2 = 0;
        int max3 = 0;
        int max4 = 0;
        for (int num : nums) {
            if (Math.abs(num) > Math.abs(max1)) {
                max4 = max3;
                max3 = max2;
                max2 = max1;

                max1 = num;
            } else if (Math.abs(num) > Math.abs(max2)) {
                max4 = max3;
                max3 = max2;

                max2 = num;
            } else if (Math.abs(num) > Math.abs(max3)) {
                max4 = max3;
                max3 = num;
            } else if (Math.abs(num) > Math.abs(max4)) {
                max4 = num;
            }
        }
        System.out.print(" " + max1 + " " + max2 + " " + max3 + " " + max4+" ");
        int tmp1 = max1 * max2 * max3;
        int tmp2 = max1 * max2 * max4;
        int tmp3 = max1 * max4 * max3;
        int tmp4 = max4 * max2 * max3;
        int result1 = (tmp1 > tmp2 ? tmp1 : tmp2);
        int result2 = (tmp3 > tmp4 ? tmp3 : tmp4);
        return result1 > result2 ? result1 : result2;
    }

    public static void main(String[] args) {
        int[] num = {174,-524,-624,903,982,-219,126,876,-875,-617,-495,-621,194,-333,804,-199,-916,-88,-706,562,-293,-876,-697,975,-6,197,544,-919,-487,432,-849,512,619,44,252,-388,-177,-256,-847,-206,114,116,-827,518,-511,-511,257,-630,56,706,675,-705,-211,170,-13,684,836,-708,336,728,511,-229,-403,310,206,539,784,666,506,-252,-34,709,233,-290,633,29,-550,-412,-778,-107,-123,724,-58,-97,71,776,104,207,-381,-132,88,312,-39,478,-817,-484,-929,651,434,-911};
        
        System.out.println(maximumProduct(num));
        
        Arrays.sort(num);
        System.out.println(" "+ num[0]+" "+ num[1]+ " "+ num[num.length-1]+" "+ num[num.length-2]);
    }

}
