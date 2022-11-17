# 剑指 Offer 42. 连续子数组的最大和

## Java

### 滑动窗口解法

我们可以在窗口内元素之和大于等于 0 时扩大窗口，在窗口内元素之和小于 0 时缩小窗口，在每次移动窗口时更新答案。

首先讨论一种特殊情况，就是 nums 中全是负数的时候，此时算法是可以得到正确答案的。

接下来讨论一般情况，nums 中有正有负，这种情况下元素和最大的那个子数组一定是以正数开头的（以负数开头的话，把这个负数去掉，就可以得到和更大的子数组了，与假设相矛盾）。那么此时我们需要穷举所有以正数开头的子数组，计算他们的元素和，找到元素和最大的那个子数组。

说到这里，解法代码的逻辑应该就清晰了。算法只有在窗口元素和大于 0 时才会不断扩大窗口，并且在扩大窗口时更新答案，这其实就是在穷举所有正数开头的子数组，寻找子数组和最大的那个，所以这段代码能够得到正确的结果。

```Java
class Solution {
    // 滑动窗口思路
    public int maxSubArray(int[] nums) {
        int left = 0, right = 0;
        int windowSum = 0, maxSum = Integer.MIN_VALUE;
        while(right < nums.length) {
            // 在窗口内元素和为正时，扩大窗口
            windowSum += nums[right];
            right ++;

            // 每次扩大完窗口，更新最大值
            maxSum = windowSum > maxSum ? windowSum : maxSum;

            // 在窗口内元素和为负时，收缩窗口
            while(windowSum < 0) {
                windowSum -= nums[left];
                left ++;
            }
        }
        return maxSum;
    }
}
```

### 动态规划的解法

以 nums[i] 为结尾的「最大子数组和」为 dp[i]。

依然使用数学归纳法来找状态转移关系：假设我们已经算出了 dp[i-1]，如何推导出 dp[i] 呢？

可以做到，dp[i] 有两种「选择」，要么与前面的相邻子数组连接，形成一个和更大的子数组；要么不与前面的子数组连接，自成一派，自己作为一个子数组。

```Java
class Solution {
    // 动态规划思路
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        // 定义dp数组,dp[i]代表以nums[i]结尾的最大子数组和为dp[i]
        int[] dp = new int[n];
        // base case
        // 第一个元素只能独自成为一个子数组
        dp[0] = nums[0];
        // 状态转移方程计算出每个元素的dp值
        for(int i = 1 ; i < n ; i ++) {
            // 对于单个元素来说，有两种选择
            // 如果以前一个元素结尾的最大子数组加上自己的和，不如自己单独成组的值大，则自己单独成组
            // 否则与前一个最大子数组连接起来
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        }

        // 遍历dp数组，找出最大子数组和
        int res = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i ++) {
            if(dp[i] > res) {
                res = dp[i];
            }
        }
        return res;

    }
}
```

### 前缀和的解法

回顾一下，前缀和数组 preSum 就是 nums 元素的累加和，preSum[i+1] - preSum[j] 其实就是子数组 nums[j..i] 之和（根据 preSum 数组的实现，索引 0 是占位符，所以 i 有一位索引偏移）。

那么反过来想，以 nums[i] 为结尾的最大子数组之和是多少？其实就是 preSum[i+1] - min(preSum[0..i])。

所以，我们可以利用前缀和数组计算以每个元素结尾的子数组之和，进而得到和最大的子数组：

```Java
class Solution {
    // 前缀和思路
    public int maxSubArray(int[] nums) {
        int n = nums.length;
        // 定义并填充前缀和数组
        int[] preSum = new int[n + 1];
        // 占位符
        preSum[0] = 0;
        for(int i = 1 ; i <= n ; i ++) {
            preSum[i] = preSum[i - 1] + nums[i - 1];
        }

        int minPreSum = Integer.MAX_VALUE;
        int res = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i ++) {
            // 维护minPreSum是preSum[0..i]的最小值
            minPreSum = Math.min(minPreSum, preSum[i]);
            // 以nums[i]结尾的最大子数组和为preSum[i + 1] - minPreSum
            res = Math.max(res, preSum[i + 1] - minPreSum);
        }
        return res;
    }
}
```