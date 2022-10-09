# 剑指 Offer II 022. 链表中环的入口节点

**#快慢指针**

## Java
```Java
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        // 使用快慢指针的方式
        ListNode fast = head;
        ListNode slow = head;

        while ( fast!= null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if( fast == slow) {
                break;
            }
        }

        if( fast == null || fast.next == null) {
            return null;
        }

        slow = head;
        while(fast != slow) {
            fast = fast.next;
            slow = slow.next;
        }

        return fast;
    }
}
```