# 剑指 Offer 04. 二维数组中的查找

## Java

```Java
class Solution {
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        if(matrix.length == 0) {
            return false;
        }
        // 初始化在右上角
        int m = matrix.length;
        int n = matrix[0].length;

        int i = 0, j = n - 1;

        while(i < m && j >= 0) {
            if(matrix[i][j] == target) {
                return true;
            } else if(matrix[i][j] < target) {
                // 小了往下找
                i ++;
            } else if(matrix[i][j] > target) {
                // 大了往左找
                j --;
            }
        }

        return false;
    }
}
```