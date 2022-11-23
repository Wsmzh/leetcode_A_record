# 剑指 Offer 54. 二叉搜索树的第k大节点

## Java

利用BST的中序遍历特性（BST中序遍历的结果是有序的）

```Java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public int kthLargest(TreeNode root, int k) {
        // 利用BST的中序遍历特性（BST中序遍历的结果是有序的）
        traverse(root, k);
        return res;
    }

    // 记录结果
    private int res = 0;
    // 记录当前元素的排名
    private int rank = 0;

    private void traverse(TreeNode root, int k) {
        if(root == null) {
            return ;
        }
        traverse(root.right, k);
        // 中序位置
        rank ++;
        if(rank == k) {
            res = root.val;
            return ;
        }
        traverse(root.left, k);
    }
}
```