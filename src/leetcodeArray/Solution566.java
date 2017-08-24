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
 * @date 2017-8-23
 *
 */
public class Solution566 {

    public int[][] matrixReshape(int[][] nums, int r, int c) {
        int r1 = nums.length;
        int c1 = nums[0].length;
        if ((r1*c1) != (r *c)) {
             return nums;
        }
        int[][] result = new int[r][c];
        for (int i = 0; i < r1*c1; i++) {
            int row1 = i / c1;
            int col1 = i % c1;
            int row = i / c;
            int col = i % c;
            
            result[row][col]=nums[row1][col1];
        }
        

        return result;
    }

}
