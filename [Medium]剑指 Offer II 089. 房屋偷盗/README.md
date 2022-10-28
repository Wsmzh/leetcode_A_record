# 剑指 Offer II 089. 房屋偷盗

## Java

```Java
class Solution {
    public int rob(int[] nums) {
        return dp(nums, 0);
    }

    private int dp(int[] nums, int start){
        int n = nums.length;
        if(start >= n) {
            return 0;
        }
        int dp_i_1 = 0, dp_i_2 = 0;
        int dp_i = 0;
        for(int i = n - 1 ; i >= 0 ; i --){
            dp_i = Math.max(dp_i_1, nums[i] + dp_i_2);
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }

        return dp_i;
    }
}
```