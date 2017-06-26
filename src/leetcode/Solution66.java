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
 * @date 2017-6-21
 *
 */
public class Solution66 {

    public int[] plusOne(int[] digits) {
        if (digits == null || digits.length == 0) {
            return digits;
        }

        int carry = 1;

        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i] = digits[i] + carry;
            if (digits[i] > 9) {
                carry=1;
                digits[i] = digits[i] % 10;

            } else {
                carry = 0;
                break;
            }
        }
        if (carry == 1) {
            int[] result = new int[digits.length + 1];
            System.arraycopy(digits, 0, result, 1, digits.length);
            result[0] = carry;
            return result;
        }

        return digits;

    }

}
