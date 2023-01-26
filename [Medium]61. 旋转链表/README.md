# 61. 旋转链表

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
    public ListNode rotateRight(ListNode head, int k) {
        if(k == 0 || head == null || head.next == null) {
            return head;
        }
        int n = 0;
        ListNode p = head;
        while(p != null) {
            n ++;
            p = p.next;
        }
        // 得到n是链表的长度
        k = k % n;
        p = head;
        while(p.next != null) {
            p = p.next;
        }
        // 成环
        p.next = head;
        // 找新的尾节点
        int count = n - k;
        while(count > 0) {
            p = p.next;
            count --;
        }
        // 新的头节点
        ListNode newHead = p.next;
        // 断环
        p.next = null;
        return newHead;
    }
}
```