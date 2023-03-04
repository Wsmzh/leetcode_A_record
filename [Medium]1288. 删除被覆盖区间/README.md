# 1288. 删除被覆盖区间

## Java

```Java
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        // 按照起点升序，终点降序的规则排序
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        // 左右边界
        int left = intervals[0][0];
        int right = intervals[0][1];
        // 记录被覆盖的区间数
        int count = 0;

        // 从第二个区间开始遍历，判断是否被覆盖了
        for(int i = 1 ; i < intervals.length ; i ++) {
            // 情况1，被覆盖
            if(intervals[i][0] >= left && intervals[i][1] <= right) {
                count ++;
            }
            // 情况2，相交
            if(right >= intervals[i][0] && right <= intervals[i][1]) {
                right = intervals[i][1];
            }
            //  情况3，不相交
            if(right < intervals[i][0]) {
                left = intervals[i][0];
                right = intervals[i][1];
            }
        }
        return intervals.length - count;
    }
}
```