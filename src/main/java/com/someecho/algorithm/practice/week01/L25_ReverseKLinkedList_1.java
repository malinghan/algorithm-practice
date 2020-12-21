package com.someecho.algorithm.practice.week01;

/**
 * @author : linghan.ma
 * @Package com.someecho.algorithm.practice.week01
 * @Description:
 * @date Date : 2020年12月20日 4:19 AM
 **/
public class L25_ReverseKLinkedList_1 {
    
    public static void main(String[] args) {
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        ListNode res = new L25_ReverseKLinkedList_1().reverseKGroup(head,2);
        while (res!= null){
            System.out.println(res.val);
            res =res.next;
        }
    }
    
    //dummy -> head(pre-start) -> ----- -> end -> next
    public ListNode reverseKGroup(ListNode head, int k) {
          //1.
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode end = dummy;
        // dummy(pre) -> head
        //上面的while条件保证了
        //1. for-k的时候不会溢出
        //2. end相当于一个终止符,容易理解
        while(end.next != null){
            for (int i = 0; i < k; i++) {
                end = end.next;
            }
            if(end == null){
                break;
            }
            ListNode next = end.next;
            end.next = null;
            ListNode start = pre.next;
            pre.next = reverse(start);
            //pre -> start -> end -> next
            //pre -> end -> start -> next
            start.next = next;
            pre = start;
        }
        return dummy.next;
    }
    
    
    //null   A -> B -> C -> null
    //null
   // null<- A  B -> C -> null
    //pre   head next
    private ListNode reverse(ListNode head){
        ListNode pre = null;
        while(head != null){
            ListNode next = head.next;
            head.next = pre;
            pre = head;
            head = next;
       }
       return pre;
    }
}
