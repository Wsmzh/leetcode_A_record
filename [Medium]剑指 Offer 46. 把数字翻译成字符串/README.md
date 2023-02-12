# 剑指 Offer 46. 把数字翻译成字符串

## Java

```Java
class Solution {
    public int translateNum(int num) {
        // 先将数字转为字符串
        String s = num + "";
        int n = s.length();
        // 如果字符串长度为0，直接返回
        if(n == 0) {
            return 0;
        }
        // 创建dp数组
        // dp[i]表示s[0...i-1]的翻译方式的数量
        int[] dp = new int[n + 1];
        // 0个字符的情况下，翻译方式只有1种
        dp[0] = 1;
        // 1个字符的情况下，翻译方式也只有1种
        dp[1] = 1;
        // 从2个字符到n个字符，翻译方式
        for(int i = 2 ; i < n + 1 ; i ++) {
            char c = s.charAt(i - 1), d = s.charAt(i - 2);
            if(c >= '0' && c <= '9') {
                // s[i - 1]本身可以作为一个字母
                dp[i] += dp[i - 1];
            }
            if(d == '1' || d == '2' && c <= '5') {
                // s[i - 2]和s[i - 1]结合起来表示一个字母
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}
```