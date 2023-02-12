# 剑指 Offer 12. 矩阵中的路径

## Java

```Java
class Solution {
    public boolean exist(char[][] board, String word) {
        char[] words = word.toCharArray();
        // 遍历所有的起点
        for(int i = 0 ; i < board.length ; i ++) {
            for(int j = 0 ; j < board[0].length ; j ++) {
                if(dfs(board, words, i, j, 0)) return true;
            }
        }
        return false;
    }

    // 对于每一个起点进行一个dfs
    private boolean dfs(char[][] board, char[] words, int i, int j, int idx) {
        if(i >= board.length || j >= board[0].length || i < 0 || j < 0 || board[i][j] != words[idx]) {
            return false;
        }
        if(idx == words.length - 1) return true;
        board[i][j] = '\0';
        boolean res = dfs(board, words, i + 1, j, idx + 1) || dfs(board, words, i, j + 1, idx + 1) || dfs(board, words, i - 1, j, idx + 1) || dfs(board, words, i, j - 1, idx + 1);
        board[i][j] = words[idx];
        return res;
    }
}
```