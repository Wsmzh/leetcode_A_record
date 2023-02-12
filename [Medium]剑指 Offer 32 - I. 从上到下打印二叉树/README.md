# 剑指 Offer 32 - I. 从上到下打印二叉树

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
    public int[] levelOrder(TreeNode root) {
        if(root == null) {
            return new int[0];
        }
        // 记录结果
        List<Integer> res = new ArrayList<>();

        // BFS使用的队列
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);
        while(!q.isEmpty()) {
            int sz = q.size();
            for(int i = 0 ; i < sz ; i ++) {
                TreeNode cur = q.poll();
                res.add(cur.val);
                if(cur.left != null) {
                    q.offer(cur.left);
                }
                if(cur.right != null) {
                    q.offer(cur.right);
                }
            }
        }

        int[] r = new int[res.size()];
        for(int i = 0 ; i < r.length ; i ++) {
            r[i] = res.get(i);
        }
        return r;

    }
}
```