/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcodeArray;

/**
 * lyk_explanation:This is a demo
 *
 * @author lyk
 * @date 2017-6-21
 *
 */
public class Solution88 {

    public static void merge(int[] nums1, int m, int[] nums2, int n) {
        int tmp = 0;
        int k = 0;
        int[] result = new int[m + n];
        if (n==0) {
            return;
        }
        
        for (int i = 0; i < n; i++) {
            for (int j = tmp; j < m; j++) {
                if (nums2[i] >= nums1[j]) {
                    result[k] = nums1[j];
                    k++;
                    tmp++;
                } else {
                    result[k] = nums2[i];
                    k++;
                    break;
                }
            }
        }
        
        if (k<(m+n)) {
            System.arraycopy(nums2, k-m, result, k, m+n-k);
        }
        
        if (tmp<m) {
            System.arraycopy(nums1, tmp, result, n+tmp, m-tmp);
        }
        nums1 = result;

    }
    
    public static void main(String[] args) {
        int[] nums1 = {1,2,4,5,6};
        int[] nums2 = {3,99};
        merge(nums1, nums1.length, nums2, nums2.length);
    }

}
