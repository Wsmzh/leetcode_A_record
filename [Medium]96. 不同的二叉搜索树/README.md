# 96. 不同的二叉搜索树

## Java

```Java
class Solution {
    // 存在重叠子运算，因此使用备忘录
    int[][] memo;
    public int numTrees(int n) {
        // 备忘录初始化为0
        memo = new int[n + 1][n + 1];
        return count(1, n);
    }

    // 函数定义：返回[lo,hi]区间内的数字组成的二叉搜索树的最大种数
    private int count(int lo, int hi) {
        // 如果lo > hi说明闭区间内没有数字，是空节点，只有一种情况
        if(lo > hi) {
            return 1;
        }
        // 先查备忘录
        if(memo[lo][hi] != 0) {
            return memo[lo][hi];
        }
        int res = 0;
        for(int i = lo ; i <= hi ; i ++) {
            int left = count(lo, i - 1);
            int right = count(i + 1, hi);
            res += left * right;
        }
        // 将结果存入备忘录
        memo[lo][hi] = res;

        return res;
    }
}
```