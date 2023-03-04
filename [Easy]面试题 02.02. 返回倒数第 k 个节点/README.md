# 面试题 02.02. 返回倒数第 k 个节点

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
    public int kthToLast(ListNode head, int k) {
        ListNode fast = head;
        for(int i = 0 ; i < k ; i ++) {
            fast = fast.next;
        }
        ListNode slow = head;
        while(fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow.val;
    }
}
```