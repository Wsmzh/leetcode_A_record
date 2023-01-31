# 剑指 Offer 06. 从尾到头打印链表

## Java

### 链表

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
    List<Integer> list = new ArrayList<>();

    public int[] reversePrint(ListNode head) {
        traverse(head);
        int[] res = new int[list.size()];
        int p = 0;
        for(Integer e : list) {
            res[p] = e;
            p ++;
        }
        return res;
    }

    private void traverse(ListNode head) {
        if(head == null) {
            return ;
        }
        traverse(head.next);
        list.add(head.val);

    }
}
```

### 数组

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
    int len = 0;
    int[] res;
    int p = 0;

    public int[] reversePrint(ListNode head) {
        traverse(head);
        return res;
    }

    private void traverse(ListNode head) {
        if(head == null) {
            res = new int[len];
            return ;
        }
        len ++;
        traverse(head.next);
        res[p] = head.val;
        p ++;
    }
}
```