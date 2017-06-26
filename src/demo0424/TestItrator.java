/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package demo0424;

import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

/**
 * lyk_explanation:This is a demo
 *
 * @author lyk
 * @date 2017-4-26
 *
 */
public class TestItrator {

    enum Face {

        ONE, TWO , THREE, FOUR, FIVE, SIX
    }

    public static void main(String[] args) {
        Collection<Face> faces = Arrays.asList(Face.values());

        for (Iterator iterator = faces.iterator(); iterator.hasNext();) {
             Face f = (Face) iterator.next();
            for (Iterator iterator1 = faces.iterator(); iterator1.hasNext();) {
                
                  System.out.println(f + " " + iterator1.next());
//                System.out.println(iterator.next() + " " + iterator1.next());
            }

        }
    }

}
