# 剑指 Offer 10- II. 青蛙跳台阶问题

## Java

```Java
class Solution {
    public int numWays(int n) {
        int f_n = 0;
        int f_n_1 = 1, f_n_2 = 1;

        for(int i = 0 ; i < n ; i ++) {
            f_n = (f_n_1 + f_n_2) % 1000000007;
            f_n_2 = f_n_1;
            f_n_1 = f_n;
        }

        return f_n_2;
    }
}
```