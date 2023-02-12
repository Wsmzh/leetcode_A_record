# 面试题13. 机器人的运动范围

## Java

```Java
class Solution {
    int count = 0;
    int row;
    int col;
    public int movingCount(int m, int n, int k) {
        row = m;
        col = n;
        int[][] flag = new int[m][n];
        for(int i = 0 ; i < row ; i ++) {
            for(int j = 0 ; j < col ; j ++) {
                flag[i][j] = 0;
            }
        }
        traverse(flag, 0, 0, k);
        return count;
    }
    
    private void traverse(int[][] flag, int left, int right, int k) {

        if(left < 0 || right < 0 || left >= row || right >= col || flag[left][right] == 1){
            return ;
        }
        int x = 0;
        int leftt = left;
        while(leftt != 0){
            x += leftt % 10;
            leftt /= 10;
        }
        int y = 0;
        int rightt = right;
        while(rightt != 0){
            y += rightt % 10;
            rightt /= 10;
        }
        if(x + y > k) {
            return ;
        } else {
            flag[left][right] = 1;
            count ++;
            traverse(flag, left + 1, right, k);
            traverse(flag, left - 1, right, k);
            traverse(flag, left, right + 1, k);
            traverse(flag, left, right - 1, k);
        }
    }
}
```