# 200. 岛屿数量

## Java

```Java
class Solution {
    public int numIslands(char[][] grid) {
        int m = grid.length, n = grid[0].length;
        int res = 0;
        for(int i = 0 ; i < m ; i ++) {
            for(int j = 0 ; j < n ; j ++) {
                if(grid[i][j] == '1') {
                    // 岛屿数量加一
                    res ++;
                    dfs(grid, i, j);
                }
            }
        }
        return res;
    }

    // 从i,j开始，将与之相邻的陆地都变成海水
    private void dfs(char[][] grid, int i, int j) {
        int m = grid.length, n = grid[0].length;
        // 越过边界直接返回
        if(i < 0 || j < 0 || i == m || j == n) {
            return ;
        }
        // 遇到水返回
        if(grid[i][j] == '0') {
            return ;
        }
        // 将岛屿变成海水，此操作是为了避免维护visited数组，防止走回头路
        grid[i][j] = '0';
        // 向四周遍历
        dfs(grid, i - 1, j);
        dfs(grid, i + 1, j);
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);

    }
}
```