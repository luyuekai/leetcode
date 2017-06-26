/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package collections;

/**
 * lyk_explanation:This is a demo
 * @author lyk
 * @date   2017-4-26
 *
 */
public class Test {
    public boolean test(int sum,int a, int b, int c){
        for (int i = 0; i <= sum/a + 1; i++) {
            for (int j = 0; j <= sum/b + 1; j++) {
                for (int k = 0; k <= sum/c + 1; k++) {
                    if (a*i + b*i + k*c == sum) {
                        return true;
                    }
                }
                
            }
            
        }
        return false;
    }
    
    public static void main(String[] args) {
        Test t = new Test();
        System.out.println(t.test(21, 6, 9, 10));
    }

}
