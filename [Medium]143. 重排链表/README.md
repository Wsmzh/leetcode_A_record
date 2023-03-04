# 143. 重排链表

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
    public void reorderList(ListNode head) {
        if(head.next == null) {
            return ;
        }
        // 先找中点
        ListNode slow = head, fast = head;
        ListNode pre = null;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            pre = slow;
            slow = slow.next;
        }
        pre.next = null;
        
        ListNode newHead = reverse(slow);

        ListNode p1 = head;
        ListNode p2 = newHead;
        ListNode dummy = new ListNode();
        ListNode p = dummy;
        boolean flag = true;
        while(p1 != null && p2 != null) {
            if(flag == true) {
                p.next = p1;
                p1 = p1.next;
                p = p.next;
                flag = false;
            } else {
                p.next = p2;
                p2 = p2.next;
                p = p.next;
                flag = true;
            }
        }
        while(p1 != null) {
            p.next = p1;
            p1 = p1.next;
            p = p.next;
        }
        while(p2 != null) {
            p.next = p2;
            p2 = p2.next;
            p = p.next;
        }
        
    }

    private ListNode reverse(ListNode head) {
        if(head.next == null) {
            return head;
        }

        ListNode newHead = reverse(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }
}
```