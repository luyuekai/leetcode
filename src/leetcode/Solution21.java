/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package leetcode;

/**
 *
 * @author 卢跃凯
 */
public class Solution21 {

    public class ListNode {

        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
        }
    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode l3 = null;
        ListNode result = null;
        if (l1==null) {
            return l2;
        }else if (l2==null) {
            return l1;
        }
        if (l1.val > l2.val) {
            l3 = l2;
            l2 = l2.next;
        } else {
            l3 = l1;
            l1 = l1.next;
        }
        result = l3;
        while (l1.next != null && l2.next != null) {
            if (l1.val > l2.val) {
                l3.next = l2;
                l2 = l2.next;
                l3 = l3.next;
            } else {
                l3.next = l1;
                l1 = l1.next;
                l3 = l3.next;
            }

        }
        if (l1.next == null) {
            l3.next = l2;
        } else {
            l3.next = l1;
        }
        return result;
    }
}
