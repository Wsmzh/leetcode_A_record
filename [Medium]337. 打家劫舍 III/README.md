# 337. 打家劫舍 III

## Java

### 按照带备忘录的动态规划解法（常规）
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

    // 备忘录
    private Map<TreeNode, Integer> memo = new HashMap<>();

    public int rob(TreeNode root) {
        if(root == null) return 0;

        if(memo.containsKey(root)) {
            return memo.get(root);
        }

        // 抢，然后去下下家
        int do_it = root.val + (root.left == null ? 0 : rob(root.left.left) + rob(root.left.right))
                            + (root.right == null ? 0 : rob(root.right.left) + rob(root.right.right));
        // 不抢，然后去下家
        int not_do = rob(root.left) + rob(root.right);

        int res = Math.max(do_it, not_do);
        memo.put(root, res);

        return res;
    }
}
```

### 重新定义递归函数后，不再需要备忘录的解法
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
    public int rob(TreeNode root) {
        int[] res = dp(root);
        return Math.max(res[0], res[1]);
    }

    /** 返回一个大小为2的数组 arr
    arr[0] 表示不抢root的情况下得到的最大钱数
    arr[1] 表示抢root的情况下得到的最大钱数*/
    private int[] dp(TreeNode root) {
        if(root == null) {
            return new int[]{0, 0};
        }
        int[] left = dp(root.left);
        int[] right = dp(root.right);

        // 抢，下家就不能抢了
        int rob = root.val + left[0] + right[0];
        //不抢，下家可抢可不抢，取决于收益大小
        int not_rob = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);

        return new int[]{not_rob, rob};
    }
}
```