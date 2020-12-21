package com.someecho.algorithm.practice.week01;

/**
 * @author : linghan.ma
 * @Package com.someecho.algorithm.practice.week01
 * @Description:
 * @date Date : 2020年12月20日 3:02 AM
 **/
public class L141_hasCircle_1 {
    
    public static void main(String[] args) {
        ListNode head = new ListNode(-21);
        head.next = new ListNode(10);
        head.next.next = new ListNode(17);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(-21);
        head.next.next.next.next.next.next = new ListNode(5);
        System.out.println(new L141_hasCircle_1().hasCycle(head));
    }
    
    public boolean hasCycle(ListNode head) {
        //快慢指针，然后判断是否有环
        if(head == null){
            return false;
        }
        ListNode quick = head;
        ListNode slow = head;
        while(quick.next != null && quick.next.next != null){
            quick = quick.next.next;
            slow = slow.next;
            if(quick == slow){
                return true;
            }
        }
        return false;
    }
    
    public boolean hasCycle1(ListNode head){
        if(head == null || head.next == null){
            return false;
        }
        if(head.next == head){
            return true;
        }
        ListNode nextNode = head.next;
        head.next = head;
        return hasCycle1(nextNode);
    }
    
    public boolean hasCycle2(ListNode head) {
        while( head != null ) {
            if( head.val == 0xcafebabe ){
                return true;
            }
            head.val = 0xcafebabe; // Mark this node as visited
            head = head.next;
        }
        return false;
    }
}
