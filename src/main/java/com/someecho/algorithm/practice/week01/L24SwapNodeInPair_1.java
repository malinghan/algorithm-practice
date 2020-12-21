package com.someecho.algorithm.practice.week01;

/**
 * @author : linghan.ma
 * @Package com.someecho.algorithm.practice.week01
 * @Description: 24. Swap Nodes in Pairs
 * @link https://leetcode.com/problems/swap-nodes-in-pairs/
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You may not modify the values in the list's nodes. Only nodes itself may be changed.
 * @date Date : 2020年12月15日 3:18 AM
 *
 * 两两交换链表节点
   
   first:  next
   second:  next.next
   swap: second.next = first;

       tmp f    s    m
  2 -> 1 -> 3 -> 4 -> 5 -> 6
       tmp  s    f
  2 -> 1 -> 4 -> 3 -> 5 -> 6;
 
  dummy
  head
  first
  second
 **/
public class L24SwapNodeInPair_1 {
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode res = new L24SwapNodeInPair_1().swapPairs(head);
        while (res!= null){
            System.out.println(res.val);
            res =res.next;
        }
    }
    
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null){
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;
        while(prev.next != null && prev.next.next != null){
            ListNode first = prev.next;
            ListNode second = prev.next.next;
            prev.next = second;
            first.next = second.next;
            second.next = first;
            prev = first.next;
        }
        return dummy.next;
    }
    
    //head -> ss -> tail
    //ss -> head -> tail
        public ListNode swapPairs1(ListNode head) {
            if(head == null || head.next == null){
                return head;
            }
            ListNode tail = swapPairs1(head.next);
            ListNode res = head.next;
            head.next.next = head;
            head.next = tail;
            return res;
        }
}
