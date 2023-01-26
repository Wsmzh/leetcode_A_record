# 9. 回文数

## Java

```Java
class Solution {
    public boolean isPalindrome(int x) {
        // 如果是负数，则肯定不是回文数
        if(x < 0) {
            return false;
        }

        // 否则计算出倒序数进行判断
        int cur = 0;
        int num = x;
        while(num != 0) {
            cur = cur * 10 + num % 10;
            num = num / 10;
        }

        return cur == x;
    }
}
```