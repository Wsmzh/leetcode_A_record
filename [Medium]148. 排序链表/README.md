# 148. 排序链表

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
    // 递归函数的定义：给定链表头节点head，使以head为头节点的链表有序
    public ListNode sortList(ListNode head) {
        // 节点为空或只有一个节点时返回
        if(head == null || head.next == null) {
            return head;
        }
        // 归并排序，寻找中间节点
        ListNode fast = head.next;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        // 找到后半段链表的头节点
        ListNode tmp = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        ListNode right = sortList(tmp);

        // 对前后两个排序完成的链表进行并排序
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while(left != null && right != null) {
            if(left.val <= right.val) {
                p.next = left;
                left = left.next;
            } else {
                p.next = right;
                right = right.next;
            }
            p = p.next;
        }
        p.next = left == null ? right : left;
        return dummy.next;
    }
}
```