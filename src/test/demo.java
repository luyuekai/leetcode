///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//package test;
//
///**
// * lyk_explanation:This is a demo
// *
// * @author lyk
// * @date 2017-4-25
// *
// */
//public class demo {
//
//    public static int fenpei(int count, int a, int b, int c) {
//        int t1 = count / 5;
//        int t2 = count / 8;
//        int t3 = count / 10;
//        int result = 0;
//
//        for (int i = 0; i <= t1 && i<=a ; i++) {
//            if (5*i>count) {
//                break;
//            }
//            for (int j = 0; j <= t2 && j<=b ; j++) {
//                if (5*i + 8*j>count) {
//                    break;
//                }
//                for (int k = 0; k <= t3&& k<= c; k++) {
//                    if (5 * i + 8 * j + 10 * k == count  ) {
//                        
//                        result++;
//                    }
//                }
//
//            }
//        }
//        return result;
//    }
//
//    public static void main(String[] args) {
////        Scanner scanner = new Scanner(System.in);
////        int n = scanner.nextInt();
//        
//        int result = demo.fenpei(23, 3, 2, 3);
//        System.out.println(result);
//        
//    }
//
//}

import java.util.Scanner;

public class demo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[][] input = new int[3][2];
        input[0][0] = 5;
        input[0][1] = scanner.nextInt();
        input[1][0] = 8;
        input[1][1] = scanner.nextInt();
        input[2][0] = 10;
        input[2][1] = scanner.nextInt();
        System.out.println(count(n, 3, input[2][1], input));
    }

    public static int count(int n, int q, int count, int[][] prices) {
        if (n < 0 || q <= 0) {
            return 0;
        }
        if (n == 0) {
            return 1;
        }
        if (count > 0) {
            count--;
            return count(n - prices[q - 1][0], q, count, prices) + (q > 1 ? count(n, q - 1, prices[q - 2][1], prices) : 0);
        }
        return q > 1 ? count(n, q - 1, prices[q - 2][1], prices) : 0;
    }
}
