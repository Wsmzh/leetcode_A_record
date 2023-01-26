# 142. 环形链表 II

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
        ListNode slow = head;
        ListNode fast = head;

        // 快慢指针
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
            if(fast == slow) {
                break;
            }
        }

        // 如果无环
        if(fast == null || fast.next == null) {
            return null;
        }

        // 有环找入口点
        slow = head;
        while(fast != slow) {
            slow = slow.next;
            fast = fast.next;
        }

        return slow;

    }
}
```