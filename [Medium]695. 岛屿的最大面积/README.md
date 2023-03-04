# 695. 岛屿的最大面积

## Java

```Java
class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0;
        for(int i = 0 ; i < m ; i ++) {
            for(int j = 0 ; j < n ; j ++) {
                // 对于每一个位置进行一个dfs
                res = Math.max(res, dfs(grid, i, j));
            }
        }

        return res;
    }

    private int dfs(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;

        if(i < 0 || j < 0 || i == m || j == n) {
            return 0;
        }

        if(grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = 0;

        int up = dfs(grid, i - 1, j);
        int down = dfs(grid, i + 1, j);
        int left = dfs(grid, i, j - 1);
        int right = dfs(grid, i, j + 1);

        int sum = up + down + left + right + 1;

        return sum;
    }
}
```