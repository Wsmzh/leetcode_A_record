# 11. 盛最多水的容器

## Java

```Java
class Solution {
    public int maxArea(int[] height) {
        int n = height.length;
        int res = 0;

        int left = 0, right = n - 1;

        while(left < right) {
            // [left, right]之间矩形的面积
            int cur_area = Math.min(height[left], height[right]) * (right - left);
            res = Math.max(res, cur_area);

            // 双指针技巧，移动较低的一段
            if(height[left] < height[right]) {
                left ++;
            } else {
                right --;
            }
        }
        
        return res;
    }
}
```