# 198. 打家劫舍

## Java

### 动态规划初始版本，存在着重叠子问题，超出时间限制
```Java
class Solution {
    // 主函数
    public int rob(int[] nums) {
        return dp(nums, 0);
    }
    // 返回nums[start...]能抢到的最大值
    private int dp(int[] nums, int start){
        if(start >= nums.length){
            return 0;
        }

        int res = Math.max(
            dp(nums, start + 1),
            nums[start] + dp(nums, start + 2)
        );

        return res;
    }
}
```

### 使用备忘录消除重叠子问题
```Java
class Solution {
    // 备忘录
    private int[] memo;
    // 主函数
    public int rob(int[] nums) {
        memo = new int[nums.length + 2];
        Arrays.fill(memo, -1);
        return dp(nums, 0);
    }
    // 返回nums[start...]能抢到的最大值
    private int dp(int[] nums, int start){
        if(start >= nums.length){
            return 0;
        }

        // 如果备忘录中存在，直接返回
        if(memo[start] != -1) return memo[start];

        int res = Math.max(
            dp(nums, start + 1),
            nums[start] + dp(nums, start + 2)
        );

        // 保存到备忘录中，方便下次使用
        memo[start] = res;

        return res;
    }
}
```

### 以上为自顶向下，还可以使用自底向上
```Java
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        /**
            dp[i] = x表示
            从第i间房子开始抢劫，最多能抢到的钱为x
            base case：dp[n] = 0
         */
        int[] dp = new int[n + 2];
        for(int i = n - 1 ; i >= 0 ; i --){
            // 当前面对的房子为状态，选择是抢还是不抢
            dp[i] = Math.max(dp[i + 1], nums[i] + dp[i + 2]);
        }

        return dp[0];
    }
}
```

### 上述自底向上算法中，dp[i]只与dp[i+1]和dp[i+2]有关系，因此优化空间复杂度
```Java
class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        /**
            dp[i] = x表示
            从第i间房子开始抢劫，最多能抢到的钱为x
            base case：dp[n] = 0
         */
        int dp_i_1 = 0, dp_i_2 = 0;
        int dp_i = 0;
        for(int i = n - 1 ; i >= 0 ; i --){
            // 当前面对的房子为状态，选择是抢还是不抢
            dp_i = Math.max(dp_i_1, nums[i] + dp_i_2);
            dp_i_2 = dp_i_1;
            dp_i_1 = dp_i;
        }

        return dp_i;
    }
}
```