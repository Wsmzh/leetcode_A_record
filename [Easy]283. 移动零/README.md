# 283. 移动零

**#快慢指针**

## Java

```Java
class Solution {
    public void moveZeroes(int[] nums) {
        // 将所有0移动到数组的末尾
        // 可以换一种思路，即将所有非0元素移动到开头，然后把后面的都置为0即可
        // 这种思路便是利用快慢指针技巧
        int fast = 0, slow = 0;
        while(fast < nums.length) {
            if(nums[fast] != 0) {
                nums[slow] = nums[fast];
                slow ++;
            }
            fast ++;
        }
        while(slow < nums.length) {
            nums[slow] = 0;
            slow ++;
        }
    }
}
```