# 95. 不同的二叉搜索树 II

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
    public List<TreeNode> generateTrees(int n) {
        if(n == 0) {
            return new LinkedList<>();
        }

        return build(1, n);
    }

    // 返回使用[lo, hi]区间中的数生成的二叉搜索树集合
    private List<TreeNode> build(int lo, int hi) {
        List<TreeNode> res = new ArrayList<>();

        // base case，区间为空，则返回null，表示空节点
        if(lo > hi) {
            res.add(null);
            return res;
        }

        // 遍历所有的根节点
        for(int i = lo ; i <= hi ; i ++) {
            // 递归构造出所有合法的左右子树集合
            List<TreeNode> leftNodes = build(lo, i - 1);
            List<TreeNode> rightNodes = build(i + 1, hi);

            // 穷举所有的左右子树的组合
            for(TreeNode leftNode : leftNodes) {
                for(TreeNode rightNode : rightNodes) {
                    // 构造树
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    // 添加到结果链表
                    res.add(root);
                }
            }
        }

        return res;
    }
}
```