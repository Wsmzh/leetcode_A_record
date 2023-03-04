# 583. 两个字符串的删除操作

## Java

```Java
class Solution {
    int[][] memo;
    public int minDistance(String word1, String word2) {
        // 记录两个字符串的长度
        int m = word1.length(), n = word2.length();

        // 备忘录
        memo = new int[m][n];
        for(int[] row : memo) {
            Arrays.fill(row, -1);
        }

        // 得到两个字符串的最长公共子序列的长度
        int len = lcs(word1, 0, word2, 0);

        return m - len + n - len;
    }

    private int lcs(String s1, int i, String s2, int j) {
        if(i == s1.length() || j == s2.length()) {
            return 0;
        }

        if(memo[i][j] != -1) {
            return memo[i][j];
        }

        if(s1.charAt(i) == s2.charAt(j)) {
            memo[i][j] = 1 + lcs(s1, i + 1, s2, j + 1);
        } else {
            memo[i][j] = Math.max(
                lcs(s1, i + 1, s2, j),
                lcs(s1, i, s2, j + 1)
            );
        }
        return memo[i][j];
    }
}
```