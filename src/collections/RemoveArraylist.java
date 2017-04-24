/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package collections;

/**
 * lyk_explanation:This is a demo
 *
 * @author lyk
 * @date 2017-4-24
 *
 */
import java.util.ArrayList;
import java.util.Iterator;

public class RemoveArraylist {

    public static void remove1(ArrayList<Integer> al) {
        for (int i = 0; i < al.size(); i++) {
            int tmp = al.get(i);
            if (tmp < 10) {
                al.remove(Integer.valueOf(tmp));
                i--;
            }
        }
        System.out.println("ArrayList: " + al);
    }

    public static void remove2(ArrayList<Integer> al) {
        Iterator<Integer> alIterable = al.iterator();
        while (alIterable.hasNext()) {
            int tmp = alIterable.next();
            if (tmp < 10) {
                alIterable.remove();
            }
        }
        System.out.println("ArrayList: " + al);

    }

    public static void main(String[] args) {

        ArrayList<Integer> al = new ArrayList<>();
        al.add(1);
        al.add(2);
        al.add(3);
        al.add(10);
        al.add(11);
        al.add(12);
        al.add(4);
        al.add(5);
        al.add(6);
        al.add(45);
        RemoveArraylist.remove1(al);
        RemoveArraylist.remove2(al);

    }

}
