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

/*
 我们需要32次迭代。 每一次迭代计算 1的数量，对于 number中的每一位。 因为 majority必定存在，因此1的数目大于0的数目。
 majority1的 位数 一定是最多的。
*/
public class Solution169_lab {

    public static int majorityElement(int[] nums) {
        int[] bit = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                if ((num >> (31 - i) & 1) == 1) {
                    bit[i]++;
                }
            }
        }
        int ret = 0;
        for (int i = 0; i < 32; i++) {
            bit[i] = bit[i] > nums.length / 2 ? 1 : 0;
            ret += bit[i] * (1 << (31 - i));
        }
        return ret;
    }
    
        public static int majorityElement2(int[] nums) {
            int count = 0;
            int tmp = 0;
            int tmp2 =0;
            for (int num : nums) {
                if (tmp == num) {
                    count++;
                }else{
                    tmp2 = num;
                    count--;
                }
                if (count<0) {
                    tmp = tmp2;
                    count=0;
                }
            }
            return tmp;
        }
    
    public static void main(String[] args) {
        int[] test = {3,3,4};
        System.out.println(majorityElement2(test));
        
        
    }

}
