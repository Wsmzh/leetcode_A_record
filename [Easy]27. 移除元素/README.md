# 27. 移除元素

**#快慢指针**

## Java
```Java
class Solution {
    public int removeElement(int[] nums, int val) {
        // 快慢指针
        int fast = 0, slow = 0;

        while(fast < nums.length) {
            if(nums[fast] != val) {
                // 先赋值再给slow++，可以保证nums[0..slow-1]是不包含值为val的元素的
                nums[slow] = nums[fast];
                slow ++;
            }
            fast ++;
        }

        return slow;
    }
}
```