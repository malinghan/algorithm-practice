package com.someecho.algorithm.practice.week01;

/**
 * @author : linghan.ma
 * @Package com.someecho.algorithm.practice.week01
 * @Description: 206. 反转链表
 * @date Date : 2020年12月15日 3:09 AM
 * @link https://leetcode-cn.com/problems/reverse-linked-list/
 * 反转一个单链表。
 * 输入: 1->2->3->4->5->NULL
 * 输出: 5->4->3->2->1->NULL
 *
 **/
public class L206ReverseLinkedList_1 {
    
    //    1 -> 2 -> 3 -> 4 -> null
    //    prev curr  next
//       null <- 1   2 -> 3
    public ListNode reverseList(ListNode head) {
        ListNode prev = null;
        while (head !=null){
            ListNode next = head.next;
            head.next = prev;
            prev = head;
            head = next;
        }
        return prev;
    }
}
