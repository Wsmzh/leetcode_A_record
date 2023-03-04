# 31. 下一个排列

## Java

```Java
class Solution {
    public void nextPermutation(int[] nums) {
        // 数组长度
        int len = nums.length;

        // 从后往前遍历，找到第一组升序的数对
        for(int i = len - 1 ; i > 0 ; i --) {
            // 找到了
            if(nums[i] > nums[i - 1]) {
                // 还是从后往前遍历，找到第一个比nums[i - 1]大的数
                for(int j = len - 1 ; j >= i ; j --) {
                    if(nums[j] > nums[i - 1]) {
                        // 将这两个数交换
                        int temp = nums[i - 1];
                        nums[i - 1] = nums[j];
                        nums[j] = temp;
                        // 交换完之后，从i到最后进行升序排列
                        Arrays.sort(nums, i, len);
                        // 直接返回
                        return ;
                    }
                }
            }
        }
        // 当不存在升序的数对，说明整个数组是降序排列，因此，直接返回其升序排列结果
        Arrays.sort(nums);
        return ;
    }
}
```