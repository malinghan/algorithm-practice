package com.someecho.algorithm.practice.week01;

import java.util.HashSet;
import java.util.Set;

/**
 * @author : linghan.ma
 * @Package com.someecho.algorithm.practice.week01
 * @Description:
 * @date Date : 2020年12月20日 3:08 AM
 **/
public class L142_hasCycleII_1 {
    
    /**
     * 使用数学公式计算
     *
     * ----A----|-----B-------|
     *          |--C--|------|
     *
     *   s = A +B
     *   f = A+B+nN
     *   => 2(A+B) = A+B+ nN;
     *   => A+B = nN
     *   => A = nN - B
     *   => A = (n-1)N + C
     *  所以如果存在环的话，s1从A点遍历， s从相遇点遍历，一定会重合在循环节点入口
     *
     * https://leetcode.com/problems/linked-list-cycle-ii/discuss/44774/Java-O(1)-space-solution-with-detailed-explanation.
     * @param head
     * @return
     */
    public ListNode detectCycle(ListNode head) {
        if(head == null){
            return null;
        }
        ListNode fast = head;
        ListNode slow = head;
        while(fast.next != null && fast.next.next != null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow){
                ListNode slow2 = head;
                while(slow2 != slow){
                    slow2 = slow2.next;
                    slow = slow.next;
                }
                return slow;
            }
        }
        
        // A -> B -> C
        return null;
    }
    
    /**
     * 方法er:广度优先遍历？
     *
     * 一个非常直观的思路是：我们遍历链表中的每个节点，并将它记录下来；
     * 一旦遇到了此前遍历过的节点，就可以判定链表中存在环。借助哈希表可以很方便地实现。
     */
    public ListNode detectCycle1(ListNode head) {
        ListNode pos = head;
        Set<ListNode> visited = new HashSet<>();
        while (pos != null) {
            if (visited.contains(pos)) {
                return pos;
            } else {
                visited.add(pos);
            }
            pos = pos.next;
        }
        return null;
    }
    
    public static void main(String[] args) {
        ListNode head = new ListNode(-21);
        head.next = new ListNode(10);
        head.next.next = new ListNode(17);
        head.next.next.next = new ListNode(8);
        head.next.next.next.next = new ListNode(4);
        head.next.next.next.next.next = new ListNode(-21);
        head.next.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next.next = head;
        System.out.println(new L142_hasCycleII_1().detectCycle(head).val);
        System.out.println(new L142_hasCycleII_1().detectCycle1(head).val);
    }
}
