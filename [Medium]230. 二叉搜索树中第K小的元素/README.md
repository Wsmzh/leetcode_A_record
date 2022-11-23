# 230. 二叉搜索树中第K小的元素

## Java

利用二叉搜索树的特性：中序遍历有序

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
    public int kthSmallest(TreeNode root, int k) {
        traverse(root, k);
        return res;
    }

    // 记录结果
    private int res = 0;
    
    // 记录当前节点的排名
    private int rank = 0;

    private void traverse(TreeNode root, int k) {
        if(root == null) {
            return ;
        }

        traverse(root.left, k);

        rank ++;
        if(rank == k) {
            res = root.val;
            return ;
        }

        traverse(root.right, k);

    }
}
```