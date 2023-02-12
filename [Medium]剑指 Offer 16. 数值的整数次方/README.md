# 剑指 Offer 16. 数值的整数次方

## Java

```Java
class Solution {
    public double myPow(double x, int n) {
        // base case
        if(n == 0) {
            return 1;
        }

        // 特殊情况处理
        if(n == Integer.MIN_VALUE) {
            return myPow(1 / x, -(n + 1)) / x;
        }

        // 幂 < 0
        if(n < 0) {
            return myPow(1 / x, -n);
        }

        // 幂为奇数
        if(n % 2 == 1) {
            return (x * myPow(x, n - 1));
        } else {
            // 幂为偶数
            double sub = myPow(x, n / 2);
            return (sub * sub);
        }
    }
}
```