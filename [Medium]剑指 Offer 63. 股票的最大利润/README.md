# 剑指 Offer 63. 股票的最大利润

## Java

```Java
class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int[][] dp = new int[n][2];

        if(n == 0){
            return 0;
        }

        for(int i = 0 ; i < n ; i ++){
            // base case
            if(i - 1 == -1){
                dp[i][0] = 0;
                dp[i][1] = -prices[i];
                continue;
            }

            //状态转移
            dp[i][0] = Math.max(dp[i-1][0], dp[i-1][1] + prices[i]);
            dp[i][1] = Math.max(dp[i-1][1], - prices[i]);
        }

        return dp[n - 1][0];
    }
}
```