# 70. 爬楼梯

## Java

```Java
class Solution {
    public int climbStairs(int n) {
        if(n == 1 || n == 2) {
            return n;
        }
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for(int i = 3 ; i <= n ; i ++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }
}
```

### 空间优化

```Java
class Solution {
    public int climbStairs(int n) {
        int p = 0, q = 0, r = 1;
        for(int i = 1 ; i <= n ; i ++) {
            p = q;
            q = r;
            r = p + q;
        }
        return r;
    }
}
```