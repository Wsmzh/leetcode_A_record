# 167. 两数之和 II - 输入有序数组

**#左右指针**

## Java
```Java
class Solution {
    public int[] twoSum(int[] numbers, int target) {
        // 左右指针
        int left = 0, right = numbers.length - 1;

        while(left < right) {
            int sum = numbers[left] + numbers[right];
            if(sum == target) {
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left ++;
            } else if (sum > target) {
                right --;
            }
        }

        return new int[]{-1, -1};
    }
}
```