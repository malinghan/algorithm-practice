## 思路

https://leetcode-cn.com/problems/swap-nodes-in-pairs/solution/dong-hua-yan-shi-24-liang-liang-jiao-huan-lian-bia/

## method1: 迭代


## method2: 递归


```java
class Solution {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode tail = swapPairs(head.next.next);
        ListNode res = head.next;
        head.next.next = head;
        head.next = tail;
        return res;
    }
}
```