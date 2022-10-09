# 剑指 Offer II 023. 两个链表的第一个重合节点

**#双指针技巧**

## Java
```Java
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {

        // 定义两个指针分别指向两个单链表的头节点
        ListNode p1 = headA;
        ListNode p2 = headB;

        while(p1 != p2) {
            if(p1 == null) {
                p1 = headB;
            } else {
                p1 = p1.next;
            }

            if(p2 == null) {
                p2 = headA;
            } else {
                p2 = p2.next;
            }
        }

        return p1;
    }
}
```