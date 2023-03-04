# 712. 两个字符串的最小ASCII删除和

## Java

```Java
class Solution {
    int[][] memo;
    public int minimumDeleteSum(String s1, String s2) {

        int m = s1.length();
        int n = s2.length();
        
        // memo[i][j] 表示 s1[i...]和s2[j...]为了相等所需删除的ASCII值的最小和
        memo = new int[m][n];
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }

        return dp(s1, 0, s2, 0);
    }

    // 返回s1[i...]和s2[j...]相等所需删除字符的ASCII值的最小和
    private int dp(String s1, int i, String s2, int j) {
        int res = 0;
        // i到最后的时候，需要将s2中j后面的全部删除
        if(i == s1.length()) {
            for(; j < s2.length() ; j ++) {
                res += s2.charAt(j);
            }
            return res;
        }
        if(j == s2.length()) {
            for(; i < s1.length() ; i ++) {
                res += s1.charAt(i);
            }
            return res;
        }

        // 先看memo
        if(memo[i][j] != -1) {
            return memo[i][j];
        }

        // 如果s1[i]和s2[j]相同
        if(s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = dp(s1, i + 1, s2, j + 1);
        } else {
            memo[i][j] = Math.min(
                s1.charAt(i) + dp(s1, i + 1, s2, j),
                s2.charAt(j) + dp(s1, i, s2, j + 1)
            );
        }

        return memo[i][j];
    }
}
```