# 86.分隔链表

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
    public ListNode partition(ListNode head, int x) {
        // 一分为二后再合二为一

        // 存放小于x的节点的虚拟头节点
        ListNode dummy1 = new ListNode(-1);
        // 存放大于等于x的节点的虚拟头节点
        ListNode dummy2 = new ListNode(-1);

        // 初始化两个指针指向上面两个新链表尾部
        ListNode p1 = dummy1;
        ListNode p2 = dummy2;

        // 初始化一个指针指向题目给我们的链表
        ListNode p = head;

        // 从头到尾遍历题目给的链表
        while(p != null) {
            // 如果当前节点值小于x
            if(p.val < x) {
                p1.next = p;
                p1 = p1.next;
            // 如果大于等于
            } else {
                p2.next = p;
                p2 = p2.next;
            }
            // 断开原链表中每个节点的next指针
            ListNode temp = p.next;
            p.next = null;
            // p前进一步
            p = temp;
        }

        // 将新生成的两个链表首位链接
        p1.next = dummy2.next;
        // 返回结果
        return dummy1.next;
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
    pub fn partition(head: Option<Box<ListNode>>, x: i32) -> Option<Box<ListNode>> {
        // 同样创建两个虚拟头节点
        let mut sentinel1 = Box::new(ListNode::new(-1));
        let mut sentinel2 = Box::new(ListNode::new(-1));

        // 创建两个指针指向这两个哨兵节点
        let mut ptr1 = &mut sentinel1;
        let mut ptr2 = &mut sentinel2;

        // 创建一个指针指向题目给出的链表头节点
        let mut p = head;

        // 遍历
        while let Some(mut node) = p {
            p = node.next.take();
            
            if node.val < x {
                ptr1.next = Some(node);
                ptr1 = ptr1.next.as_mut().unwrap();
            } else {
                ptr2.next = Some(node);
                ptr2 = ptr2.next.as_mut().unwrap();
            }
        }

        ptr1.next = sentinel2.next;
        sentinel1.next
    }
}
```
