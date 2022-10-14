# 51. N 皇后

## C++

```C++
class Solution {
public:
    vector<vector<string>> res;
    // 输入棋盘边长n，返回所有合法的放置
    vector<vector<string>> solveNQueens(int n) {
        // vector<string>代表一个棋盘
        vector<string> board(n, string(n, '.'));
        backtrack(board, 0);
        return res;
    }

    // 路径：board中小于row的那些行都已经成功放置了皇后
    // 选择列表：第row行的所有列都是放置皇后的选择
    // 结束条件：row超过board的最后一行
    void backtrack(vector<string>& board, int row) {
        // 触发结束条件
        if(row == board.size()) {
            res.push_back(board);
            return ;
        }

        int n = board[row].size();
        for(int col = 0 ; col < n ; col ++) {
            // 排除不合法选择
            if(!isValid(board, row, col)) {
                continue;
            }
            // 做选择
            board[row][col] = 'Q';
            // 进入下一行决策
            backtrack(board, row + 1);
            board[row][col] = '.';
        }
    }

    // 是否可以在board[row][col]放置皇后
    bool isValid(vector<string>& board, int row, int col) {
        int n = board.size();
        for(int i = 0 ; i <= row ; i ++) {
            if(board[i][col] == 'Q')
                return false;
        }

        for(int i = row - 1, j = col + 1;
            i >= 0 && j < n; i--, j++) {
                if(board[i][j] == 'Q')
                    return false;
        }
        for(int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--){
            if(board[i][j] == 'Q')
                return false;
        }
        return true;
    }
};
```