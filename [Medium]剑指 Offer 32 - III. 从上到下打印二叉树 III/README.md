# 剑指 Offer 32 - III. 从上到下打印二叉树 III

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        if(root == null) {
            return new ArrayList();
        }
        // 结果
        List<List<Integer>> res = new ArrayList<>();
        // 队列
        Queue<TreeNode> q = new LinkedList<>();
        // 控制顺序
        boolean flag = true;

        q.offer(root);
        while(!q.isEmpty()) {
            int sz = q.size();
            LinkedList<Integer> l = new LinkedList<>();
            for(int i = 0 ; i < sz ; i ++) {
                TreeNode cur = q.poll();
                if(flag == true) {
                    l.addLast(cur.val);
                } else {
                    l.addFirst(cur.val);
                }
                if(cur.left != null) {
                    q.offer(cur.left);
                }
                if(cur.right != null) {
                    q.offer(cur.right);
                }
            }
            flag = !flag;
            res.add(l);
        }
        return res;
    }
}
```