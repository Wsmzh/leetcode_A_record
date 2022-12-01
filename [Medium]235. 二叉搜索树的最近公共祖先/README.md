# 235. 二叉搜索树的最近公共祖先

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
        // 这样做保证val1 < val2，以便与更好的利用BST左小右大的性质
        int val1 = Math.min(p.val, q.val);
        int val2 = Math.max(p.val, q.val);
        return find(root, val1, val2);
    }

    private TreeNode find(TreeNode root, int val1, int val2) {
        // base case
        if(root == null) {
            return null;
        }

        // 如果当前节点的值大于val2，则说明这两个节点的最近公共祖先一定在左子树上
        if(root.val > val2) {
            return find(root.left, val1, val2);
        }
        // 相反，一定在右子树上
        if(root.val < val1) {
            return find(root.right, val1, val2);
        }

        // 第三种情况，val1 < root.val < val2，则说明root是最近公共祖先
        return root;
    }
}
```