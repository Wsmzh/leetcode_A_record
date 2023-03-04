# 41. 缺失的第一个正数

## Java

```Java
class Solution {
    // 原地哈希
    public int firstMissingPositive(int[] nums) {
        int len = nums.length;

        for(int i = 0 ; i < len ; i ++) {
            // 一定要是while，仅仅一次if的话不能保证当前nums[i] = i + 1
            while(nums[i] > 0 && nums[i] <= len && nums[i] != nums[nums[i] - 1]) {
                int temp = nums[nums[i] - 1];
                nums[nums[i] - 1] = nums[i];
                nums[i] = temp;
            }
        }

        for(int i = 0 ; i < len ; i ++) {
            if(nums[i] != i + 1) {
                return i + 1;
            }
        }
        return len + 1;
    }
}
```