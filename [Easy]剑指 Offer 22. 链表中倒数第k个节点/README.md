# 剑指 Offer 22. 链表中倒数第k个节点

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
    public ListNode getKthFromEnd(ListNode head, int k) {
        ListNode p1 = head;

        for(int i = 0 ; i < k ; i ++) {
            p1 = p1.next;
        }

        ListNode p2 = head;

        while(p1 != null) {
            p1 = p1.next;
            p2 = p2.next;
        }

        return p2;
    }
}
```