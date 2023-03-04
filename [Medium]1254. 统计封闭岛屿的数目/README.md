# 1254. 统计封闭岛屿的数目

## Java

```Java
class Solution {
    public int closedIsland(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // 先把四周边缘的陆地淹没
        for(int j = 0 ; j < n ; j ++) {
            dfs(grid, 0, j);
            dfs(grid, m - 1, j);
        }
        for(int i = 0 ; i < m ; i ++) {
            dfs(grid, i, 0);
            dfs(grid, i, n - 1);
        }

        int res = 0;
        for(int i = 0 ; i < m ; i ++) {
            for(int j = 0 ; j < n ; j ++) {
                if(grid[i][j] == 0) {
                    res ++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    private void dfs(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if(i < 0 || j < 0 || i == m || j == n) {
            return;
        }
        if(grid[i][j] == 1) {
            return ;
        }
        grid[i][j] = 1;
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
```