# 912. 排序数组

## Java

### 快速排序模版

```Java
class Solution {
    public int[] sortArray(int[] nums) {
        Quick.sort(nums);
        return nums;
    }
}

class Quick {

    public static void sort(int[] nums) {
        sort(nums, 0, nums.length - 1);
    }

    private static void sort(int[] nums, int left, int right) {
        // 排序区间只剩一个元素
        if(left >= right) {
            return ;
        }

        // 使用partition函数返回切点
        int p = partition(nums, left, right);
        sort(nums, left, p - 1);
        sort(nums, p + 1, right);
    }

    // 切分函数，操作数组并返回p，使得nums[left, p - 1]都小于nums[p]，nums[p + 1, right]都大于nums[p]
    private static int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int lo = left + 1, hi = right;
        while(lo <= hi) {
            while(lo < right && nums[lo] <= pivot) {
                lo ++;
                // 跳出此循环时,nums[lo]恰好> pivot
            }
            while(hi > left && nums[hi] > pivot) {
                hi --;
                // 跳出此循环时,nums[hi]恰好<= pivot
            }

            // 存在的意义为
            // 对于[5,1,2,3,4]这个数组排序是，lo指向4了，hi也指向4，这样下去会无限循环，所以要特殊处理
            if(lo >= hi) {
                break;
            }

            swap(nums, lo, hi);
        }
        swap(nums, hi, left);
        return hi;
    }

    private static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

}
```