# 416. 分割等和子集

## Java

```Java
class Solution {
    public boolean canPartition(int[] nums) {
        // 先求数组中整数的和
        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        // 特判，如果和为奇数则肯定不能
        if(sum % 2 == 1) {
            return false;
        }

        // 和除以2，初始化背包容量
        sum /= 2;
        boolean[][] dp = new boolean[nums.length + 1][sum + 1];

        // base case sum=0时，肯定能装满
        for(int i = 0 ; i <= nums.length ; i ++) {
            dp[i][0] = true;
        }

        for(int i = 1 ; i <= nums.length ; i ++) {
            for(int j = 1 ; j <= sum ; j ++) {
                if(j - nums[i - 1] < 0) {
                    dp[i][j] = dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - nums[i - 1]];
                }
            }
        }

        return dp[nums.length][sum];

    }
}
```