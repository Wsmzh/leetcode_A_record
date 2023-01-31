# 剑指 Offer 53 - II. 0～n-1中缺失的数字

## Java

有序数组搜索优先考虑二分。

```Java
class Solution {
    public int missingNumber(int[] nums) {
        int i = 0, j = nums.length - 1;
        while(i <= j) {
            int m = i + (j - i) / 2;
            if(nums[m] == m) i = i + 1;
            else j = j - 1;
            // 循环跳出时，i指向右子数组的第一位
            // j指向左子数组的最后一位
        }
        return i;
    }
}

// 或者

class Solution {
    public int missingNumber(int[] nums) {
        // 找index和value不相同的左侧边界
        int left = 0, right = nums.length - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(mid < nums[mid]) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
}
```