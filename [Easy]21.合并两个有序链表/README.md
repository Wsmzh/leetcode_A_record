# 21.合并两个有序链表

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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        // 首先定义虚拟头节点
        ListNode dummy = new ListNode(-1);
        ListNode p = dummy;

        // 定义双指针分别指向两个链表头
        ListNode p1 = list1;
        ListNode p2 = list2;

        // 双指针依次遍历
        while(p1 != null && p2 != null) {
            // 判断找出较小的节点加入到新生成的链表中
            if(p1.val < p2.val) {
                p.next = p1;
                p1 = p1.next;
            } else {
                p.next = p2;
                p2 = p2.next;
            }
            // p每次移动一步
            p = p.next;
        }

        // 肯定有一个链表先遍历完
        if(p1 != null){
            p.next = p1;
        }

        if(p2 != null){
            p.next = p2;
        }

        // 返回虚拟头节点的下一个节点
        return dummy.next;
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
    pub fn merge_two_lists(list1: Option<Box<ListNode>>, list2: Option<Box<ListNode>>) -> Option<Box<ListNode>> {
        
        // 首先同样定义虚拟投头节点即哨兵节点
        let mut sentinel = ListNode::new(-1);
        let mut current = &mut sentinel;

        let (mut p1, mut p2) = (list1, list2);

        // 依次便利
        while p1.is_some() && p2.is_some() {
            // 比较两个链表中当前头部节点值的大小
            if p1.as_ref().unwrap().val < p2.as_ref().unwrap().val {
                let mut node1 = p1.unwrap();
                p1 = node1.next.take();
                current.next = Some(node1);
            } else {
                let mut node2 = p2.unwrap();
                p2 = node2.next.take();
                current.next = Some(node2);
            }
            // 每次current移动一步
            current = current.next.as_mut().unwrap();
        }

        // 肯定有一个链表先遍历完，而另一个还有剩余
        if p1.is_some() {
            current.next = p1;
        }

        if p2.is_some() {
            current.next = p2;
        }

        // 最后返回哨兵节点的next节点
        sentinel.next
    }
}
```
