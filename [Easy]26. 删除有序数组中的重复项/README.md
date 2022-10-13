# 26. 删除有序数组中的重复项

**#快慢指针**

## Java
```Java
class Solution {
    public int removeDuplicates(int[] nums) {
        // 快慢指针技巧
        int slow = 0;
        int fast = 0;

        // 题目要求进行原地修改，所以只能在原数组上操作
        while(fast < nums.length) {
            // fast走在前面，找到一个不重复的元素就赋值给slow并让slow前进一步
            if(nums[fast] != nums[slow]) {
                slow ++;
                // 维护nums[0..slow]无重复
                nums[slow] = nums[fast];
            }
            fast ++;
        }

        return slow + 1;
    }
}
```

## Rust
```Rust
impl Solution {
    pub fn remove_duplicates(nums: &mut Vec<i32>) -> i32 {
        // 使用快慢指针技巧
        let mut slow = 0;
        let mut fast = 0;

        // fast在前遍历直到数组末尾
        while fast < nums.len() {
            if nums[fast] != nums[slow] {
                slow += 1;
                nums[slow] = nums[fast];
            }
            fast += 1;
        }
        let res = slow + 1;
        return res as i32;
    }
}
```