# 213. 打家劫舍 II

## Java

### 首位房间不能同时抢，那么只有三种情况
### 1、都不抢（收益最低，直接排除）
### 2、只抢第一个房间，不抢最后一个房间
### 3、只抢最后一个房间，不抢第一个房间
```Java
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if(n == 1) return nums[0];
        // 即然首位相连，那么第一个和最后一个房间只能挑一个来偷，所以分成两种情况，最后取最大值
        return Math.max(robRange(nums, 0, n - 2),
                        robRange(nums, 1, n - 1));

    }

    // 计算闭区间[start, end]的最优结果
    private int robRange(int[] nums, int start, int end) {
        int n = nums.length;
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