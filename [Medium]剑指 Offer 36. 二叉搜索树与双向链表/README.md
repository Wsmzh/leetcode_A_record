# 剑指 Offer 36. 二叉搜索树与双向链表

## Java

```Java
/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val,Node _left,Node _right) {
        val = _val;
        left = _left;
        right = _right;
    }
};
*/
class Solution {
    Node pre, head;
    public Node treeToDoublyList(Node root) {
        if(root == null) {
            return null;
        }
        dfs(root);
        // 进行首尾连接
        pre.right = head;
        head.left = pre;
        return head;
    }
    private void dfs(Node cur) {
        if(cur == null) {
            return ;
        }
        // 中序遍历
        dfs(cur.left);

        // pre指代前序节点
        // pre == null时表示该节点是双向链表的头节点
        if(pre == null) {
            head = cur;
        } else {
            // 否则表示该节点是左子树的最后一个节点，也是双向链表中的前序节点
            pre.right = cur;
        }
        // 建立连接关系
        cur.left = pre;
        
        // 更新pre，因为对于右子树来说，当前节点是右子树的前序节点
        pre = cur;

        dfs(cur.right);
    }
}
```