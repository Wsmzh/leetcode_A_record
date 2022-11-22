# 剑指 Offer 47. 礼物的最大价值

## Java

```Java
class Solution {
    public int maxValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n];

        // 采用dp数组
        // base case
        dp[0][0] = grid[0][0];

        // 状态转移
        // 先算左边界和上边界上的
        for(int i = 1 ; i < m ; i ++){
            dp[i][0] = dp[i - 1][0] + grid[i][0];
        }
        for(int i = 1 ; i < n ; i ++){
            dp[0][i] = dp[0][i - 1] + grid[0][i];
        }

        // 再算内部的
        for(int i = 1 ; i < m ; i ++){
            for(int j = 1 ; j < n ; j ++){
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[m - 1][n - 1];
    }

}
```