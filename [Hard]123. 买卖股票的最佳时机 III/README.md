# 123. 买卖股票的最佳时机 III

## Java

```Java
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int k = 2;
        int[][][] dp = new int[n][k + 1][2];

        for(int i = 0 ; i < n ; i ++){
            //base case
            if(i - 1 == -1){
                dp[i][2][0] = 0;
                dp[i][2][1] = - prices[i];
                dp[i][1][0] = 0;
                dp[i][1][1] = -prices[i];
                continue;
            }

            // 状态转移
            dp[i][2][0] = Math.max(dp[i - 1][2][0], dp[i - 1][2][1] + prices[i]);
            dp[i][2][1] = Math.max(dp[i - 1][2][1], dp[i - 1][1][0] - prices[i]);
            dp[i][1][0] = Math.max(dp[i - 1][1][0], dp[i - 1][1][1] + prices[i]);
            dp[i][1][1] = Math.max(dp[i - 1][1][1], - prices[i]);

        }
        
        return dp[n - 1][k][0];
    }
}
```