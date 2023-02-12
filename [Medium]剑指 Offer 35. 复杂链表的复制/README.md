# 剑指 Offer 35. 复杂链表的复制

## Java

```Java
/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/
class Solution {
    public Node copyRandomList(Node head) {
        // 先将所有的Node克隆好
        HashMap<Node, Node> o2c = new HashMap<>();
        for(Node p = head ; p != null ; p = p.next) {
            if(!o2c.containsKey(p)) {
                o2c.put(p, new Node(p.val));
            }
        }
        // 将所有的关系进行连接
        for(Node p = head ; p != null ; p = p.next) {
            if(p.next != null) {
                o2c.get(p).next = o2c.get(p.next);
            }
            if(p.random != null) {
                o2c.get(p).random = o2c.get(p.random);
            }
        }

        return o2c.get(head);
    }
}
```