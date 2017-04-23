/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package test;

/**
 * lyk_explanation:This is a demo
 * @author lyk
 * @date   2017-4-6
 *
 */

//int fun(int n){
//    int sum=0;
//    while(n){
//        sum+=n%10;
//        n/=10;
//    }
//    return sum;
//}
//int main()
//{
//    int n;
//    scanf("%d",&n);
//    printf("%d",fun(n));       
//    return 0;
//}
public class test1 {
    static int fun(int n){
        int sum=0;
        while (n!=0) { 
            sum+=n%10;
            n/=10;
            
        }
        return sum;
    }
    public static void main(String[] args) {
        int result = 0;
        for (int i = 0; i <= 2000000; i++) {
            result+= test1.fun(i);
        }
        System.out.println(result);
    }

}
