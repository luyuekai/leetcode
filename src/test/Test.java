/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 *
 * @author 卢跃凯
 */
public class Test {
    
    public static int negetiveNumber(int x){
       
        
        return Integer.reverseBytes(x);
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int result = Test.negetiveNumber(1);
        System.out.println(result);
    }
    
}
