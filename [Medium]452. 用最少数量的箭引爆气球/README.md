# 452. 用最少数量的箭引爆气球

## Java

```Java
class Solution {
    public int findMinArrowShots(int[][] points) {
        // 按照end排序
        Arrays.sort(points, (a, b) -> {
            // 防止整数溢出
            if(a[1] > b[1]) {
                return 1;
            } else {
                return -1;
            }
        });

        int count = 1;
        int end = points[0][1];
        
        for(int i = 1 ; i < points.length ; i ++) {
            if(points[i][0] > end) {
                count ++;
                end = points[i][1];
            } else {
                continue;
            }
        }

        return count;
    }
}
```