# 剑指 Offer 55 - II. 平衡二叉树

## Java

后序位置和“全局”变量的妙用

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
    public boolean isBalanced(TreeNode root) {
        traverse(root);
        return flag;
    }

    // 用一个变量记录二叉树是否平衡
    private boolean flag = true;

    private int traverse(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = traverse(root.left);
        int rightHeight = traverse(root.right);

        // 后序位置的妙用，直接判断二叉树是否平衡
        if(Math.abs(leftHeight - rightHeight) > 1) {
            flag = false;
        }

        return Math.max(leftHeight, rightHeight) + 1;
    }
}
```