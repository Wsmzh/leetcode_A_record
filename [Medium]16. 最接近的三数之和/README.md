# 16. 最接近的三数之和

## Java

```Java
class Solution {

    public int threeSumClosest(int[] nums, int target) {
        int n = nums.length;

        // 当前三数之和与target的最小差距
        int curDiff = Integer.MAX_VALUE;

        // 记录返回的三数之和
        int res = 0;

        // 先对数组排序
        Arrays.sort(nums);

        // 确定第一个数
        for(int i = 0 ; i < n ; i ++) {
            int firstNum = nums[i];
            // 确定剩余两个数的取值范围
            int left = i + 1;
            int right = n - 1;
            while(left < right) {
                // 当前三个数的和
                int curSum = firstNum + nums[left] + nums[right];
                // 如果当前三个数的和与target之差小于记录的最佳差
                if(Math.abs(curSum - target) <= curDiff) {
                    curDiff = Math.abs(curSum - target);
                    res = curSum;
                }
                // 缩小差距
                if(left < right && curSum < target) {
                    left ++;
                } else {
                    right --;
                }
            }
        }

        return res;
    }
}
```