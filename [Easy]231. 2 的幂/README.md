# 231. 2 的幂

## Java

一个数如果是2的指数，那么它的二进制表示一定只包含一个1；

位运算 `n & (n-1)` 在算法中很常见，作用是消除数字 `n` 的二进制表示中的最后一个1，用这个技巧可以判断是否是2的指数。

```Java
class Solution {
    public boolean isPowerOfTwo(int n) {
        if(n <= 0) return false;
        else return (n & (n - 1)) == 0;
    }
}
```