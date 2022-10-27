# 188. 买卖股票的最佳时机 IV

## Java

```Java
class Solution {
    public int maxProfit(int k, int[] prices) {
        int max_k = k;
        int n = prices.length;

        if(max_k > n / 2){
            return maxProfit_inf(prices);
        }

        int[][][] dp = new int[n][max_k + 1][2];
        
        // base case
        for(int i = 0 ; i < n ; i ++) {
            dp[i][0][0] = 0;
            dp[i][0][1] = Integer.MIN_VALUE;
        }

        for(int i = 0 ; i < n ; i ++){
            for(int j = max_k ; j >= 1 ; j --){
                // base case
                if(i - 1 == -1){
                    dp[i][j][0] = 0;
                    dp[i][j][1] = - prices[i];
                    continue;
                }

                // 状态转移
                dp[i][j][0] = Math.max(dp[i - 1][j][0], dp[i - 1][j][1] + prices[i]);
                dp[i][j][1] = Math.max(dp[i - 1][j][1], dp[i - 1][j - 1][0] - prices[i]);
            }
        }

        return dp[n - 1][max_k][0];

    }

    // 无交易次数限制求最大收益
    int maxProfit_inf(int[] prices){
        int n = prices.length;
        int[][] dp = new int[n][2];

        for(int i = 0 ; i < n ; i ++){
            // base case
            if(i - 1 == -1){
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }

            // 状态转移
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
        }

        return dp[n - 1][0];
    }
}
```