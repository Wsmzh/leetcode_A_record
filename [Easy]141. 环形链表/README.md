# 141. 环形链表

**#双指针技巧**

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
    public boolean hasCycle(ListNode head) {
        // 使用快慢指针的方式判断链表中是否有环
        ListNode fast = head;
        ListNode slow = head;

        // one time, fast + 2, slow + 1
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if(fast == slow) {
                return true;
            }
        }

        return false;
    }
}
```
