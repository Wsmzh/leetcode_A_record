# 54. 螺旋矩阵

## Java

```Java
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        List<Integer> res = new ArrayList<>();
        int up = 0;
        int down = m - 1;
        int left = 0;
        int right = n - 1;
        while(res.size() < m * n) {
            if(up <= down) {
                for(int j = left ; j <= right ; j ++) {
                    res.add(matrix[up][j]);
                }
                up ++;
            }
            if(left <= right) {
                for(int j = up ; j <= down ; j ++) {
                    res.add(matrix[j][right]);
                }
                right --;
            }
            if(up <= down) {
                for(int j = right ; j >= left ; j --) {
                    res.add(matrix[down][j]);
                }
                down --;
            }
            if(left <= right) {
                for(int j = down ; j >= up ; j --) {
                    res.add(matrix[j][left]);
                }
                left ++;
            }
        }

        return res;
    }
}
```