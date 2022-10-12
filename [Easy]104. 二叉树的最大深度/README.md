# 104. 二叉树的最大深度

**#二叉树思维框架**

## Java
### 遍历二叉树的思路
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

    // 记录答案
    int res = 0;

    // 记录当前节点所处的深度
    int depth = 0;

    public int maxDepth(TreeNode root) {
        traverse(root);
        return res;
    }

    private void traverse(TreeNode root) {
        if(root == null) {
            return ;
        }
        // 在前序位置，即刚进入当前节点时，深度+1
        depth ++;
        // 如果遍历到了叶子结点，则更新深度的最大值
        if(root.left == null && root.right == null) {
            res = Math.max(res, depth);
        }
        // 依次遍历左右子树
        traverse(root.left);
        traverse(root.right);
        // 在后序位置，即离开当前节点时，深度-1
        depth --;
    }
}
```

### 分解问题的思路
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
    // 定义：返回以root为根节点的二叉树的最大深度
    public int maxDepth(TreeNode root) {
        // 一颗二叉树的最大深度可以由其两个子树的深度推导出来
        if(root == null) {
            return 0;
        }

        // 分解问题，先分别获得左子树和右子树的最大深度
        int leftMax = maxDepth(root.left);
        int rightMax = maxDepth(root.right);

        // 当前节点的最大深度为左右子树中深度较大值+1
        return Math.max(leftMax, rightMax) + 1;
    }
}
```