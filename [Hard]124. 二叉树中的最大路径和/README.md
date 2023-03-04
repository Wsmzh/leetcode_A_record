# 124. 二叉树中的最大路径和

## Java

```Java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    int ans = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        traverse(root);
        return ans;
    }

    private int traverse(TreeNode root) {
        // base case
        if(root == null) {
            return 0;
        }
        // 递归计算左右子树的贡献值，如果和小于0，则切断该路径，记为0
        int left = Math.max(traverse(root.left), 0);
        int right = Math.max(traverse(root.right), 0);

        ans = Math.max(ans, left + right + root.val);
        
        // 路径不能出现分叉
        return Math.max(left, right) + root.val;
    }
}
```