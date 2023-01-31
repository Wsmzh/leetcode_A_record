# 剑指 Offer 24. 反转链表

## Java

### 迭代

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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        ListNode pre = null;
        ListNode cur = head;
        ListNode nxt = head.next;
        while(nxt != null) {
            cur.next = pre;
            pre = cur;
            cur = nxt;
            nxt = cur.next;
        }
        cur.next = pre;
        return cur;
    }
}
```

### 递归

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
    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }

        // 递归函数定义：输入一个节点，将以该节点为头节点的链表反转，并返回反转后的头节点
        ListNode last = reverseList(head.next);

        // 处理当前节点
        head.next.next = head;
        head.next = null;
    
        return last;
    }
}
```