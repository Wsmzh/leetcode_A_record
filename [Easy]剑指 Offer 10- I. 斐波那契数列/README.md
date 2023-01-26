# 剑指 Offer 10- I. 斐波那契数列

## Java

```Java
class Solution {
    public int fib(int n) {
        int f_n = 0;
        int f_n_1 = 1, f_n_2 = 0;
        for(int i = 0 ; i < n ; i ++) {
            f_n = (f_n_1 + f_n_2) % 1000000007;
            f_n_2 = f_n_1;
            f_n_1 = f_n;
        }
        return f_n_2;
    }
}
```