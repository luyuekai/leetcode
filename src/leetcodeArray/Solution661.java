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
public class Solution661 {

    public static int[][] imageSmoother(int[][] M) {

        int l = M.length - 1;
        int ll = M[0].length - 1;

        int[][] result = new int[l + 1][ll + 1];
        if ((l == 0) && (ll == 0)) {
            result[0][0] = M[0][0];
            return result;
        }
        if ((l == 0) && (ll == 1)) {
            result[0][0] = (M[0][0] + M[0][1]) / 2;
            result[0][1] = result[0][0];
            return result;
        }

        if ((l == 1) && (ll == 0)) {
            result[0][0] = (M[0][0] + M[1][0]) / 2;
            result[1][0] = result[0][0];
            return result;
        }

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[i].length; j++) {
                int result1 = result[i][j];
                if ((i == 0) && (j == 0)) {
                    int sum = M[i][j] + M[i + 1][j] + M[i + 1][j + 1] + M[i][j + 1];
                    result[i][j] = sum / 4;
                }
                if ((i == 0) && (j == ll)) {
                    int sum = M[i][j] + M[i + 1][j] + M[i + 1][j - 1] + M[i][j - 1];
                    result[i][j] = sum / 4;
                }
                if ((i == l) && (j == ll)) {
                    int sum = M[i][j] + M[i - 1][j] + M[i - 1][j - 1] + M[i][j - 1];
                    result[i][j] = sum / 4;
                }
                if ((i == l) && (j == 0)) {
                    int sum = M[i][j] + M[i - 1][j] + M[i - 1][j + 1] + M[i][j + 1];
                    result[i][j] = sum / 4;
                }

                if ((i == 0) && (0 < j) && (j < ll)) {
                    int sum = M[i][j] + M[i + 1][j] + M[i + 1][j + 1] + M[i][j + 1] + M[i][j - 1] + M[i + 1][j - 1];
                    result[i][j] = sum / 6;
                }
                if ((i == l) && (0 < j) && (j < ll)) {
                    int sum = M[i][j] + M[i - 1][j] + M[i - 1][j + 1] + M[i][j + 1] + M[i][j - 1] + M[i - 1][j - 1];
                    result[i][j] = sum / 6;
                }
                if ((j == 0) && (0 < i) && (i < l)) {
                    int sum = M[i][j] + M[i - 1][j] + M[i - 1][j + 1] + M[i][j + 1] + M[i + 1][j] + M[i + 1][j + 1];
                    result[i][j] = sum / 6;
                }
                if ((j == ll) && (0 < i) && (i < l)) {
                    int sum = M[i][j] + M[i - 1][j] + M[i - 1][j - 1] + M[i][j - 1] + M[i + 1][j] + M[i + 1][j - 1];
                    result[i][j] = sum / 6;
                }

                if ((0 < i) && (i < l) && (0 < j) && (j < ll)) {
                    int sum = M[i][j] + M[i - 1][j] + M[i - 1][j - 1] + M[i][j - 1] + M[i + 1][j] + M[i + 1][j - 1]
                            + M[i][j + 1] + M[i - 1][j + 1] + M[i + 1][j + 1];
                    result[i][j] = sum / 9;
                }

            }

        }
        return result;
    }

    public static void main(String[] args) {
        int[][] test = {{1, 1, 1}, {1, 0, 1}, {1, 1, 1}};
        imageSmoother(test);
        System.out.println("hello");
    }

}
