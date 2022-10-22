# 剑指 Offer 53 - I. 在排序数组中查找数字 I

## Java

```Java
class Solution {
    public int search(int[] nums, int target) {
        int left = startPos(nums, target);
        int right = endPos(nums, target);
        if(left == -1 && right == -1){
            return 0;
        } else {
            return right - left + 1;
        }
    }

    // 左侧边界
    int startPos(int[] nums, int target) {
        if(nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;

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

        if(left == nums.length || nums[left] != target) {
            return -1;
        }
        return left;
    }

    // 右侧边界
    int endPos(int[] nums, int target) {
        if(nums.length == 0) return -1;

        int left = 0;
        int right = nums.length - 1;

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

        if(right < 0 || nums[right] != target) {
            return -1;
        }
        return right;
    }
}
```