# 25. K 个一组翻转链表

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
    // 每k个一组进行反转，说明要反转好多组，先从每一组如何反转考虑
    // 先写一个反转链表中部分区域的函数
    private ListNode reverse(ListNode a, ListNode b) {
        // 反转链表需要三个辅助指针
        ListNode pre = null, cur = a, nxt = a;
        while( cur != b ) {
            nxt = cur.next;
            cur.next = pre;
            pre = cur;
            cur = nxt;
        }
        // 跳出while循环时，cur为b，pre才指向原来的链表尾，现在的链表头
        return pre;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head == null) return null;

        // 需要两个指针定界
        ListNode a = head, b = head;
        for(int i = 0 ; i < k ; i ++) {
            // 最后剩余的节点保持原有顺序
            if(b == null) {
                return head;
            }
            b = b.next;
        }
        // 反转[a,b)这部分链表
        ListNode newHead = reverse(a, b);
        head.next = reverseKGroup(b, k);

        return newHead;
    }

}
```