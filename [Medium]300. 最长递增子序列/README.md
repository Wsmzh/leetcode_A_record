# 300. 最长递增子序列

## Java

```Java
class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        // dp[i]表示以第i个元素结尾的最长递增子序列
        int[] dp = new int[n];
        Arrays.fill(dp, 1);

        for(int i = 0 ; i < n ; i ++) {
            for(int j = 0 ; j < i ; j ++) {
                if(nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int res = 0;
        for(int i = 0 ; i < n ; i ++) {
            res = Math.max(res, dp[i]);
        }
        return res;
        
    }
}
```