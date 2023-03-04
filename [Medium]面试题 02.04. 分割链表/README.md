# 面试题 02.04. 分割链表

## Java

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
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode();
        ListNode dummy2 = new ListNode();

        ListNode p1 = dummy1;
        ListNode p2 = dummy2;

        ListNode p = head;
        while(p != null) {
            if(p.val < x) {
                p1.next = p;
                p = p.next;
                p1 = p1.next;
                p1.next = null;
            } else {
                p2.next = p;
                p = p.next;
                p2 = p2.next;
                p2.next = null;
            }
        }

        p = dummy1;
        while(p.next != null) {
            p = p.next;
        }
        p.next = dummy2.next;
        
        return dummy1.next;
    }
}
```