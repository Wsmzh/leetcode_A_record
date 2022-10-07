# 19.删除链表的倒数第N个节点

**#双指针技巧**

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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // 需要一个哨兵节点（方便处理删除头节点这一情况）
        ListNode sentinel = new ListNode(-1);
        sentinel.next = head;
        //指针1
        ListNode ptr1 = sentinel;

        // 需要找倒数第n+1个节点，指针1前进n+1步
        for(int i = 0 ; i < n + 1 ; i ++){
            ptr1 = ptr1.next;
        }

        // 指针2
        ListNode ptr2 = sentinel;
        // 两个指针一起移动直到指针1到null
        while(ptr1 != null) {
            ptr1 = ptr1.next;
            ptr2 = ptr2.next;
        }

        // 删除题目要求的那个节点
        ptr2.next = ptr2.next.next;

        // 返回头节点
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
impl Solution {
    pub fn remove_nth_from_end(head: Option<Box<ListNode>>, n: i32) -> Option<Box<ListNode>> {
        // 创建一个哨兵节点
        let mut sentinel = Some(Box::new(ListNode::new(-1)));
        sentinel.as_mut().unwrap().next = head;

        let mut slow_p = &mut sentinel;
        let mut fast_p = &slow_p.clone();

        // 快指针前进n+1步
        for _ in 0..=n {
            if let Some(fast_node) = fast_p {
                fast_p = &fast_node.next;
            }
        }

        // 快慢指针一起前进
        while fast_p.is_some() {
            fast_p = &fast_p.as_ref().unwrap().next;
            slow_p = &mut slow_p.as_mut().unwrap().next;
        }

        // 删除节点
        let remove_p = &mut slow_p.as_mut().unwrap().next;
        slow_p.as_mut().unwrap().next = remove_p.as_mut().unwrap().next.take();

        // 返回头节点
        sentinel.unwrap().next
    }
}
```