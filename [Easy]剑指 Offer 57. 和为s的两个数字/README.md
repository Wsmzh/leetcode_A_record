# 剑指 Offer 57. 和为s的两个数字

## Java

```Java
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 左右指针
        int left = 0, right = nums.length - 1;

        while(left < right) {
            int sum = nums[left] + nums[right];
            if(sum > target) {
                right --;
            } else if(sum < target) {
                left ++;
            } else {
                return new int[] {nums[left], nums[right]};
            }
        }

        return new int[2];
    }
}
```