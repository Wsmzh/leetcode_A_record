# 剑指 Offer II 078. 合并排序链表

**#优先级队列**

**#双指针技巧衍生**

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
    public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length == 0) return null;
        
        // 首先初始化一个哨兵节点
        ListNode sentinel = new ListNode(-1);
        ListNode p = sentinel;

        // 使用优先级队列
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> (a.val - b.val));

        // 遍历链表数组，将每个链表的头节点加入到优先级队列
        for(ListNode node : lists){
            if( node != null) {
                pq.add(node);
            }
        }

        // 每次从优先级队列中弹出堆顶元素
        while(!pq.isEmpty()) {
            ListNode node = pq.poll();
            if(node.next != null) {
                pq.add(node.next);
            }
            p.next = node;
            p = p.next;
        }

        return sentinel.next;
    }
}
```