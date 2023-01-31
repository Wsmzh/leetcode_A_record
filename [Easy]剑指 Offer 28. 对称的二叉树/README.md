# 剑指 Offer 28. 对称的二叉树

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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        return mirrorOrFalse(root.left, root.right);
    }

    private boolean mirrorOrFalse(TreeNode left, TreeNode right) {
        // 两个节点都为空
        if(left == null && right == null) {
            return true;
        }
        // 一空一不空
        if(left == null || right == null) {
            return false;
        }

        // 都不空但值不同
        if(left.val != right.val) {
            return false;
        }

        // 递归对比左子树的左子树与右子树的右子树
        // 递归对比左子树的右子树与右子树的左子树
        boolean m1 = mirrorOrFalse(left.left, right.right);
        boolean m2 = mirrorOrFalse(left.right, right.left);

        // 只要有一个不对称返回false
        if(m1 == false || m2 == false) {
            return false;
        }

        // 都对称
        return true;
    }
}
```