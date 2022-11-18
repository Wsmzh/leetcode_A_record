# 215. 数组中的第K个最大元素

## Java

### 快速选择算法

```Java
class Solution {
    public int findKthLargest(int[] nums, int k) {
        int left = 0, right = nums.length - 1;
        // 转换成排名第k大的元素
        k = nums.length - k;

        while(left <= right) {
            // 在nums[left,right]中选一个分界点，这个分界点对应的元素在整个数组中的排序位确定
            int p = partition(nums, left, right);
            // 根据这个分界点，缩小搜索空间
            if(p > k) {
                // 如果p > k，说明排名为k的元素在分界点左边
                right = p - 1;
            } else if(p < k) {
                // 如果p < k，说明排名为k的元素在分界点右边
                left = p + 1;
            } else {
                // 如果p == k，则说明找到了排名为k的元素
                return nums[p];
            }
        }
        
        return -1;
    }

    // 快速排序中最重要的partition函数
    private int partition(int[] nums, int left, int right) {
        int pivot = nums[left];
        int lo = left + 1;
        int hi = right;
        while(lo <= hi) {
            while(lo < right && nums[lo] <= pivot) {
                lo ++;
            }
            while(hi > left && nums[hi] > pivot) {
                hi --;
            }
            // 为了预防[5,1,2,3,4]这种情况，如果不这样处理会无限循环下去
            if(lo >= hi) {
                break;
            }

            swap(nums, lo, hi);
        }
        swap(nums, hi, left);
        return hi;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }
}

```