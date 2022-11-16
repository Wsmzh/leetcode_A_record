# 面试题 10.03. 搜索旋转数组

## Java

```Java
// 首先明确使用二分法

class Solution {
    public int search(int[] arr, int target) {
        if (arr[0] == target) {
            return 0;
        }

        // 定义双指针
        int left = 0, right = arr.length - 1;

        // 二分查找
        while(left <= right) {
            // 先找出mid
            int mid = left + (right - left) / 2;

            // 找出mid后，分四种情况讨论

            // 1.mid所指向的值 == target
            if (arr[mid] == target ) {
                // 因为有可能有重复，所以可以向左移动mid，找到 == target且最左边的值
                while(mid > 0 && arr[mid] == arr[mid - 1]) {
                    mid --;
                }
                return mid;
            }

            // 2. arr[mid] < arr[right] 说明从mid到right 是递增的
            if(arr[mid] < arr[right]) {
                // 如果此时target > arr[mid] && target <= arr[right] 则缩小范围到(mid, right]
                if (target > arr[mid] && target <= arr[right]) {
                    left = mid + 1;
                } else {
                    // 与之相反，则缩小范围到[left, mid - 1]
                    right = mid - 1;
                }
            }
            // 3. arr[mid] > arr[right] 说明从left到mid 是递增的
            else if (arr[mid] > arr[right]) {
                // 如果此时target >= arr[left] && target < arr[mid] 则缩小范围到[left, mid)
                if(target >= arr[left] && target < arr[mid]) {
                    right = mid - 1;
                } else {
                    // 与之相反，则缩小范围到[mid + 1, right]
                    left = mid + 1;
                }
            }
            // 4.剩余一种情况就是arr[mid] == arr[right]，说明从mid到right 或者 right到mid是相等的
            else {
                // 这时只需要将right排除出选中区域即可
                right --;
            }
        }
        // 没找到返回-1
        return -1;
    }
}
```