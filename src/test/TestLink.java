/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

/**
 * lyk_explanation:This is a demo
 *
 * @author lyk
 * @date 2017-4-6
 *
 */
class ListNode {

    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}

public class TestLink {

    public static void main(String[] args) {

        ListNode l1 = new ListNode(1);
        ListNode l2 = new ListNode(2);
        ListNode cursor;
        cursor = l1;
        ListNode headNode;
        headNode = cursor;
        System.out.println(headNode.val);
        System.out.println(cursor.val);
        cursor = l2;
        System.out.println(headNode.val);
        System.out.println(cursor.val);

    }

}
