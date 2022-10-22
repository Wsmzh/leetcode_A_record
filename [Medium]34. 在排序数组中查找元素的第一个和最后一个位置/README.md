# 34. 在排序数组中查找元素的第一个和最后一个位置

## Java

```Java
class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        res[0] = startPos(nums, target);
        res[1] = endPos(nums, target);
        return res;
    }

    // 寻找开始位置，即左侧边界
    public static int startPos(int[] nums, int target) {
        if(nums.length == 0) return -1;

        int left = 0, right = nums.length - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] > target) {
                right = mid - 1;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else if(nums[mid] == target) {
                right = mid - 1;
            }
        }

        if(left == nums.length) return -1;
        return nums[left] == target ? left : -1;
    }

    // 寻找结束为止，即右侧边界
    public static int endPos(int[] nums, int target) {
        if(nums.length == 0) return -1;

        int left = 0, right = nums.length - 1;

        while(left <= right) {
            int mid = left + (right - left) / 2;
            if(nums[mid] > target) {
                right = mid - 1;
            } else if(nums[mid] < target) {
                left = mid + 1;
            } else if(nums[mid] == target) {
                left = mid + 1;
            }
        }

        if(right < 0) return -1;
        return nums[right] == target ? right : -1;
    }
}
```