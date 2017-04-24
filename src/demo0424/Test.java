/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo0424;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * lyk_explanation:This is a demo
 *
 * @author lyk
 * @date 2017-4-24
 *
 */
public class Test {

    public static void main(String[] args) {
        
        ArrayList<Integer> ints = new ArrayList<>(Arrays.asList(0,1,2,3,4,5,6));
        ints.subList(2, 4).clear();
        System.out.println(""+ ints);
    }
}
