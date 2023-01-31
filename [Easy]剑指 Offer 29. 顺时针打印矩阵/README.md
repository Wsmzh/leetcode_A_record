# 剑指 Offer 29. 顺时针打印矩阵

## Java

```Java
class Solution {
    public int[] spiralOrder(int[][] matrix) {
        if(matrix.length == 0) {
            return new int[0];
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int size = m * n;
        int[] res = new int[size];
        int p = 0;
        int upper = 0, bottom = m - 1;
        int left = 0, right = n - 1;
        while(p < size) {
            if(upper <= bottom) {
                for(int i = left ; i <= right ; i ++) {
                    res[p] = matrix[upper][i];
                    p ++;
                }
                upper ++;
            }
            if(left <= right) {
                for(int j = upper ; j <= bottom ; j ++) {
                    res[p] = matrix[j][right];
                    p ++;
                }
                right --;
            }
            if(upper <= bottom) {
                for(int i = right ; i >= left ; i --) {
                    res[p] = matrix[bottom][i];
                    p ++;
                }
                bottom --;
            }
            if(left <= right) {
                for(int j = bottom ; j >= upper ; j --) {
                    res[p] = matrix[j][left];
                    p ++;
                }
                left ++;
            }
        }
        return res;
    }
}
```