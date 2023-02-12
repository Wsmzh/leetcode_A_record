# 206. 反转链表

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
    // 函数定义：给定单链表的头节点，返回反转后的链表头节点
    public ListNode reverseList(ListNode head) {
        // 特殊情况判断
        if(head == null) {
            return null;
        }

        // 如果递归中该节点没有后续节点，说明他将作为新的头节点
        if(head.next == null) {
            return head;
        }
        
        // 将head.next为头节点的链表反转并返回新头节点
        ListNode newHead = reverseList(head.next);
        // 修改当前节点和后续节点的指向关系
        head.next.next = head;
        head.next = null;

        // 返回新头节点
        return newHead;
    }
}
```