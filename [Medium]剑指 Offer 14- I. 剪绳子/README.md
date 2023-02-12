# 剑指 Offer 14- I. 剪绳子

## Java

```Java
class Solution {
    int[] memo;
    public int cuttingRope(int n) {
        memo = new int[n + 1];
        return dp(n);
    }

    private int dp(int n) {
        if(n == 0) {
            return 0;
        }

        if(n == 1) {
            return 1;
        }

        if(n == 2) {
            return 1;
        }

        if(memo[n] > 0) {
            return memo[n];
        }

        int res = Integer.MIN_VALUE;
        for(int i = 1 ; i < n ; i ++) {
            res = Math.max(res, i * Math.max(dp(n - i), n - i));
        }
        memo[n] = res;
        return res;
    }
}
```