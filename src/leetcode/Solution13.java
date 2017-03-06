/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.

 罗马数字共有七个，即I(1)，V(5)，X(10)，L(50)，C(100)，D(500)，M(1000)。
 */
package leetcode;

/**
 * lyk_explanation:This is a demo
 *
 * @author lyk
 * @date Feb 24, 2017
 *
 */
public class Solution13 {

    public int romanToInt(String s) {
        String begin = s.charAt(0) + "";
        int beginInt = getRomanInt(begin);
        int result = beginInt;
        int current = 0;
        int last = beginInt;
        for (int i = 1; i < s.length(); i++) {
            last = getRomanInt(s.charAt(i-1)+"");
            current = getRomanInt(s.charAt(i)+"");
            if (current > last) {
                result += current - last*2;
            }else if(current == last){
                result +=current;
            }else{
                result += current; 
            }
        }
        return result;
    }

    public int getRomanInt(String word) {
        switch (word) {
            case "M":
                return 1000;
            case "D":
                return 500;
            case "C":
                return 100;
            case "L":
                return 50;
            case "X":
                return 10;
            case "V":
                return 5;
            case "I":
                return 1;
            default:
                return 0;
        }
    }
    
    public static void main(String[] args) {
        Solution13 test = new Solution13();
        System.out.println(test.romanToInt("DCXXI"));
        
    }
}
