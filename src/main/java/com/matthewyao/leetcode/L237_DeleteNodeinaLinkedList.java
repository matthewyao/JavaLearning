package com.matthewyao.leetcode;

/**
 * Created by matthewyao on 2017/1/23.
 */
public class L237_DeleteNodeinaLinkedList {

     public class ListNode {
         int val;
         ListNode next;
         ListNode(int x) { val = x; }
     }

    public void deleteNode(ListNode node) {
        node.val = node.next.val;
        node.next = node.next.next;
    }
}
