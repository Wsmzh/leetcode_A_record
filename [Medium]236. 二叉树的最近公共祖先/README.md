# 236. 二叉树的最近公共祖先

## Java

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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return find(root, p.val, q.val);
    }

    private TreeNode find(TreeNode root, int val1, int val2) {
        // base case
        if(root == null) {
            return null;
        }

        // 前序位置
        if(root.val == val1 || root.val == val2) {
            // 遇到目标值，直接返回
            return root;
        }

        // 如果不是则去左右子节点寻找
        TreeNode left = find(root.left, val1, val2);
        TreeNode right = find(root.right, val1, val2);

        // 后续位置，已经知道左右子树是否存在目标值
        if(left != null && right != null) {
            // 当前节点是LCA节点
            return root;
        }

        return left != null ? left : right;
    }
}
```