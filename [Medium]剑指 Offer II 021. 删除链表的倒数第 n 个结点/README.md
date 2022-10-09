# 剑指 Offer II 021. 删除链表的倒数第 n 个结点

**#双指针技巧**

## Java
```Java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 删除倒数第n个节点，需要找到其前置节点
        // 如果要删除的是第一个节点，那么其不存在前置节点，为了解决这个问题，考虑使用哨兵节点
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;

        ListNode p1 = sentinel;
        ListNode p2 = sentinel;

        for(int i = 0 ; i < n + 1 ; i ++) {
            p1 = p1.next;
        }

        while ( p1 != null ) {
            p1 = p1.next;
            p2 = p2.next;
        }

        p2.next = p2.next.next;
        return sentinel.next;
    }
}
```
