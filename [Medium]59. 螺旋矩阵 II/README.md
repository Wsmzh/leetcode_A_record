# 59. 螺旋矩阵 II

## Java

```Java
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] res = new int[n][n];
        int count = 1;
        int up = 0;
        int down = n - 1;
        int left = 0;
        int right = n - 1;
        while(count <= n * n) {
            if(up <= down) {
                for(int j = left ; j <= right ; j ++) {
                    res[up][j] = count;
                    count ++;
                }
                up ++;
            }
            if(left <= right) {
                for(int i = up ; i <= down ; i ++) {
                    res[i][right] = count;
                    count ++;
                }
                right --;
            }
            if(up <= down) {
                for(int j = right ; j >= left ; j --) {
                    res[down][j] = count;
                    count ++;
                }
                down --;
            }
            if(left <= right) {
                for(int i = down ; i >= up ; i --) {
                    res[i][left] = count;
                    count ++;
                }
                left ++;
            }
        }
        return res;
    }
}
```