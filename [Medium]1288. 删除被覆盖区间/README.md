# 1288. 删除被覆盖区间

## Java

```Java
class Solution {
    public int removeCoveredIntervals(int[][] intervals) {
        // 先按照起点升序，终点降序进行sort
        Arrays.sort(intervals, (a, b) -> {
            if(a[0] == b[0]) {
                return b[1] - a[1];
            }
            return a[0] - b[0];
        });

        // 记录被覆盖的区间个数
        int count = 0;

        // 覆盖区间的起点终点
        int left = intervals[0][0];
        int right = intervals[0][1];

        for(int i = 1 ; i < intervals.length ; i ++) {
            int[] t = intervals[i];
            // 三种情况
            // 1.完全覆盖
            if(t[0] >= left && t[1] <= right) {
                count ++;
            } else if(t[0] <= right && right <= t[1]) {
            // 2.相交
                left = t[0];
                right = t[1];
            } else if(t[0] > right) {
            // 3.完全不相交
                left = t[0];
                right = t[1];
            }
        }

        return intervals.length - count;
    }
}
```