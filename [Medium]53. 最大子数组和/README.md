# 53. 最大子数组和

## Java

```Java
class Solution {
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        // dp[i]表示以nums[i]结尾的连续子数组的最大和的值
        int[] dp = new int[n];
        dp[0] = nums[0];
        for(int i = 1 ; i < n ; i ++) {
            dp[i] = Math.max(nums[i], dp[i - 1] + nums[i]);
        }
        int res = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i ++) {
            res = Math.max(res, dp[i]);
        }
        return res;
    }
}
```