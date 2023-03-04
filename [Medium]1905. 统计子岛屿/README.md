# 1905. 统计子岛屿

## Java

```Java
class Solution {
    // 思路：先把不是子岛的淹没，剩下的就是子岛了（四周都是海）
    public int countSubIslands(int[][] grid1, int[][] grid2) {
        int m = grid1.length, n = grid1[0].length;
        for(int i = 0 ; i < m ; i ++) {
            for(int j = 0 ; j < n ; j ++) {
                // 如果在2中是陆地，而1中是海洋则这一区域连接的岛屿肯定不是子岛屿，全部淹没掉
                if(grid2[i][j] == 1 && grid1[i][j] == 0) {
                    dfs(grid2, i, j);
                }
            }
        }
        
        int res = 0;

        // 淹没完之后剩下的陆地就是子岛屿中的陆地，只需要计算几个岛屿即可
        for(int i = 0 ; i < m ; i ++) {
            for(int j = 0 ; j < n ; j ++) {
                if(grid2[i][j] == 1) {
                    res ++;
                    dfs(grid2, i, j);
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