# 23.合并k个有序链表

**#双指针技巧**

**#优先级队列（二叉堆）**

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
        if(lists.length == 0) {
            return null;
        }

        // 同样新建哨兵节点
        ListNode sentinel = new ListNode(-1);
        // 新建指针
        ListNode ptr = sentinel;

        // 初始化优先级队列(最小堆)
        PriorityQueue<ListNode> pq = new PriorityQueue<>(lists.length, (a, b) -> a.val - b.val);

        // 先将k个链表的头节点依次加入优先级队列，加入结束后堆顶元素便是最小的节点（细节过程参考优先级队列实现方法）
        for(ListNode listHead : lists) {
            if(listHead != null) {
                pq.add(listHead);
            }
        }

        // 每次取堆顶对应的节点加入新链表，并用该节点的next节点（若有的话）更新优先级队列
        while(!pq.isEmpty()) {
            ListNode node = pq.poll();
            if(node.next != null) {
                pq.add(node.next);
            }
            ptr.next = node;
            ptr = ptr.next;
        }

        return sentinel.next;
    }
}
```
## Rust
```Rust
// Definition for singly-linked list.
// #[derive(PartialEq, Eq, Clone, Debug)]
// pub struct ListNode {
//   pub val: i32,
//   pub next: Option<Box<ListNode>>
// }
//
// impl ListNode {
//   #[inline]
//   fn new(val: i32) -> Self {
//     ListNode {
//       next: None,
//       val
//     }
//   }
// }

use std::cmp::{Ord, Ordering, PartialEq};
use std::collections::BinaryHeap;

impl Ord for ListNode {
    fn cmp(&self, other: &Self) -> Ordering {
        other.val.cmp(&self.val)
    }
}

impl PartialOrd for ListNode {
    fn partial_cmp(&self, other: &Self) -> Option<Ordering> {
        Some(self.cmp(other))
    }
}

impl Solution {
    pub fn merge_k_lists(lists: Vec<Option<Box<ListNode>>>) -> Option<Box<ListNode>> {
        // 如果lists为空则直接返回
        if lists.is_empty() {
            return None;
        }

        // 定义哨兵节点
        let mut sentinel = Box::new(ListNode::new(-1));

        // 定义指针
        let mut ptr = &mut sentinel;

        // 初始化二叉堆
        let mut heap = BinaryHeap::new();

        // 将所有头节点加入二叉堆中
        for node in lists {
            if let Some(n) = node {
                heap.push(n);
            }
        }

        // 弹出堆顶最小元素，并根据该元素节点后是否还有节点来更新二叉堆，直到二叉堆为空
        while let Some(mut top) = heap.pop() {
            if let Some(node) = top.next.take() {
                heap.push(node);
            }
            ptr.next = Some(top);
            ptr = ptr.next.as_mut().unwrap();
        }

        sentinel.next

    }
}
```
