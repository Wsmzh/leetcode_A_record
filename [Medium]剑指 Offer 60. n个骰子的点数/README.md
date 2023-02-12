# 剑指 Offer 60. n个骰子的点数

## Java

```Java
class Solution {
    public double[] dicesProbability(int n) {
        // n个骰子掷出来的最小和最大点数
        int min = n, max = n * 6;

        // 定义dp数组,表示n个骰子出现point点数的概率
        double[][] dp = new double[n + 1][max + 1];
        // 初始化1个骰子的情况
        for(int i = 1 ; i <= 6 ; i ++) {
            dp[1][i] = 1 / 6.0;
        }

        // dp计算n个骰子的情况记录到数组中
        for(int i = 2 ; i <= n ; i ++) {
            for(int j = i ; j <= 6 * i ; j ++) {
                // 第i个骰子可以扔出1-6
                for(int k = 1 ; k <= 6 ; k ++) {
                    if(j - k <= 0) {
                        continue;
                    } else {
                        // i个骰子扔出j的概率
                        // 可以通过i-1个骰子扔出j-k的概率
                        dp[i][j] += dp[i - 1][j - k] * 1 / 6.0; 
                    }
                }
            }
        }

        double[] res = new double[max - min + 1];
        for(int i = 0 ; i < res.length ; i ++) {
            res[i] = dp[n][min + i];
        }
        return res;
    }
}
```