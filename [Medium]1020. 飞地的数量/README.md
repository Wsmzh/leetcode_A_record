# 1020. 飞地的数量


## Java

```Java
class Solution {
    
    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        // 相当于找海中孤岛
        // 并且边界之外是陆地，因此先把边界以及相连的陆地淹没
        for(int i = 0 ; i < m ; i ++) {
            if(grid[i][0] == 1) {
                dfs(grid, i, 0);
            }
            if(grid[i][n - 1] == 1) {
                dfs(grid, i, n - 1);
            }
        }
        for(int j = 0 ; j < n ; j ++) {
            if(grid[0][j] == 1) {
                dfs(grid, 0, j);
            }
            if(grid[m - 1][j] == 1) {
                dfs(grid, m - 1, j);
            }
        }

        // record 飞地数量
        int res = 0;

        // 遍历所有的地
        for(int i = 0 ; i < m ; i ++) {
            for(int j = 0 ; j < n ; j ++) {
                // 飞地
                if(grid[i][j] == 1) {
                    res ++;
                }
            }
        }

        return res;
    }

    private void dfs(int[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        if(i < 0 || j < 0 || i == m || j == n) {
            return ;
        }
        if(grid[i][j] == 0) {
            return ;
        }
        grid[i][j] = 0;
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
    }
}
```