# 剑指 Offer 21. 调整数组顺序使奇数位于偶数前面

## Java

```Java
class Solution {
    public int[] exchange(int[] nums) {
        int n = nums.length;
        int fast = 0, slow = 0;
        while(fast < n) {
            if(nums[fast] % 2 != 0) {
                int tmp = nums[slow];
                nums[slow] = nums[fast];
                nums[fast] = tmp;
                slow ++;
            }
            fast ++;
        }
        return nums;
    }
}
```