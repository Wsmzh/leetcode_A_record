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
```