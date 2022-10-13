# 509. 斐波那契数

## Java

```Java
class Solution {
    public int fib(int n) {
        if(n == 0 || n == 1) {
            return n;
        }

        int n_1 = 1, n_2 = 0;
        for(int i = 2 ; i <= n ; i ++) {
            int fn = n_1 + n_2;
            n_2 = n_1;
            n_1 = fn;
        }

        return n_1;
    }
}
```