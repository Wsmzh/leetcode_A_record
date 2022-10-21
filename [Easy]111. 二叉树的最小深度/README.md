# 111. 二叉树的最小深度

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
    public int minDepth(TreeNode root) {
        // 特判
        if(root == null) {
            return 0;
        }

        // 记录步数
        int step = 0;

        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        // while循环控制一层层往下
        while(!q.isEmpty()) {
            int sz = q.size();
            // 因为跟节点高度为1，所以步数在这里先增加
            step ++;
            // for循环控制从左往右
            for(int i = 0 ; i < sz ; i ++) {
                TreeNode node = q.poll();
                // 判断到达终点
                if(node.left == null && node.right == null) {
                    // 最先到达的终点肯定就是最小深度，直接返回且所有的返回都在这里
                    return step;
                }
                // 将相邻节点加入到队列中
                if(node.left != null) {
                    q.offer(node.left);
                }
                if(node.right != null) {
                    q.offer(node.right);
                }
            }
        }

        // 这个不写，结果无影响
        return step;
    }
}
```