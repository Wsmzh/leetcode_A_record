# 237. 删除链表中的节点

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
    public void deleteNode(ListNode node) {
        ListNode pre = node;
        ListNode cur = node.next;
        ListNode nxt = cur.next;

        while( nxt != null ) {
            pre.val = cur.val;
            pre = cur;
            cur = nxt;
            nxt = cur.next;
        }
        
        pre.val = cur.val;
        pre.next = null;
    }
}
```