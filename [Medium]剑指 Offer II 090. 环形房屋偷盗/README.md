# 剑指 Offer II 090. 环形房屋偷盗

## Java

```Java
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;

        if(n == 1){
            return nums[0];
        }
        return Math.max(dp(nums, 0, n - 2), dp(nums, 1, n - 1));

    }

    private int dp(int[] nums, int start, int end) {
        int dp_i_1 = 0, dp_i_2 = 0;
        int dp_i = 0;

        for(int i = end ; i >= start ; i --){
            dp_i = Math.max(dp_i_1, nums[i] + dp_i_2);
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }

        return dp_i;
    }
}
```