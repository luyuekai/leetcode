/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;

/**
 * lyk_explanation:This is a demo
 *
 * @author lyk
 * @date 2017-5-7
 *
 */
public class LinkedListTest {

    public static void main(String[] args) {
        List<String> a = new LinkedList<>();
        a.add("Amy");
        a.add("Carl");
        a.add("Erica");

        List<String> b = new LinkedList<>();
        b.add("Bob");
        b.add("Doug");
        b.add("Frances");
        b.add("Gloria");

        ListIterator<String> aIter = a.listIterator();
        Iterator<String> bIter = b.iterator();

        while (bIter.hasNext()) {
            if (aIter.hasNext()) {
                aIter.next();
            }
            aIter.add(bIter.next());

        }
        System.out.println(a);

        bIter = b.iterator();
        while (bIter.hasNext()) {

            bIter.next();
            if (bIter.hasNext()) {
                bIter.next();
                bIter.remove();

            }
        }
        System.out.println(b);

        a.removeAll(b);

        System.out.println(a);

    }

}
