# 42. 接雨水

## Java

### 暴力无优化解法
```Java
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int res = 0;

        // 从1到n-2，是因为左右两侧的柱子肯定无法接雨水
        for(int i = 1 ; i < n - 1 ; i ++) {
            int l_max = 0, r_max = 0;

            // 找左边最高的柱子
            for(int j = i ; j >= 0 ; j --) {
                l_max = Math.max(l_max, height[j]);
            }
            // 找右边最高的柱子
            for(int j = i ; j < n ; j ++) {
                r_max = Math.max(r_max, height[j]);
            }

            // res加上当前位置能接的雨水量
            // 如果height[i]是最高的，那么l_max == r_max == height[i]，相当于res += 0
            res += Math.min(l_max, r_max) - height[i];
        }

        return res;
    }
}
```

### 备忘录优化
```Java
class Solution {
    public int trap(int[] height) {
        if(height.length == 0) {
            return 0;
        }

        int n = height.length;
        int res = 0;

        // 定义两个备忘录，提前把每一个位置左边和右边的最高柱子高度算出来，避免重复计算
        int[] l_max = new int[n];
        int[] r_max = new int[n];
        // base case
        l_max[0] = height[0];
        r_max[n - 1] = height[n - 1];
        // 填充备忘录
        for(int i = 1 ; i < n ; i ++){
            l_max[i] = Math.max(height[i], l_max[i - 1]);
        }
        for(int i = n - 2 ; i >= 0 ; i --){
            r_max[i] = Math.max(height[i], r_max[i + 1]);
        }

        // 计算答案
        for(int i = 1 ; i < n - 1 ; i ++){
            res += Math.min(l_max[i], r_max[i]) - height[i];
        }

        return res;
    }
}
```

### 双指针优化

```Java
class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int res = 0;

        // 双指针解法
        int left = 0, right = n - 1;
        // l_max代表0-left的最高，r_max代表right-end的最高
        int l_max = 0, r_max = 0;

        while(left < right) {
            l_max = Math.max(l_max, height[left]);
            r_max = Math.max(r_max, height[right]);

            // res += Math.min(l_max, r_max) - height[i]
            if(l_max < r_max) {
                res += l_max - height[left];
                left ++;
            } else {
                res += r_max - height[right];
                right --;
            }
        }

        return res;
    }
}
```