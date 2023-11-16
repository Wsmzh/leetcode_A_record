# 435. 无重叠区间

## Java

```Java
class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        // 首先按照end排序
        Arrays.sort(intervals, (a, b) -> {
            return a[1] - b[1];
        });

        int count = 1;
        // 每次选一个end最小的区间
        int end = intervals[0][1];

        // 遍历剩余的区间
        for(int i = 1 ; i < intervals.length ; i ++) {
            // 如果当前区间和之前的区间不重叠，则更新
            if(intervals[i][0] >= end) {
                count ++;
                end = intervals[i][1];
            } else {
                // 如果重叠则continue
                continue;
            }
        }
        return intervals.length - count;
    }
}
```