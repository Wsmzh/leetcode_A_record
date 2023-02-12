# 剑指 Offer 34. 二叉树中和为某一值的路径

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
    // root - 二叉树的根节点；target - 目标整数和
    public List<List<Integer>> pathSum(TreeNode root, int target) {
        traverse(root, target);
        return res;
    }

    // 状态变量 - 记录当前从 根节点到叶子节点的路径和
    private int sum = 0;
    // 状态变量 - 记录路径
    private LinkedList<Integer> path = new LinkedList<>();
    // 记录结果
    private List<List<Integer>> res = new ArrayList<>();

    private void traverse(TreeNode root, int target) {
        if(root == null) {
            return ;
        }
        // 前序位置
        sum += root.val;
        path.addLast(root.val);
        // 判断是否满足条件
        if(root.left == null && root.right == null && sum == target) {
            res.add(new LinkedList<>(path));
        }

        traverse(root.left, target);
        traverse(root.right, target);
        // 后序位置
        sum -= root.val;
        path.removeLast();
    }

}
```