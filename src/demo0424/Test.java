/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo0424;

/**
 * lyk_explanation:This is a demo
 *
 * @author lyk
 * @date 2017-4-24
 *
 */
public class Test {

    public static void main(String[] args) {
        String s1 ="hdfs://datanode32:8020";
        String result = s1.split(":")[0]+":"+s1.split(":")[1];
        System.out.println(result);
    }
}
