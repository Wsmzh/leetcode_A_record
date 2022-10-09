# 剑指 Offer 25. 合并两个排序的链表

**#双指针技巧**

```Java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode sentinel = new ListNode(-1);
        ListNode p = sentinel;

        ListNode p1 = l1;
        ListNode p2 = l2;

        while(p1 != null && p2 != null) {
            if(p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            p = p.next;
        }

        if(p1 != null) {
            p.next = p1;
        }

        if(p2 != null) {
            p.next = p2;
        }

        return sentinel.next;
    }
}
```