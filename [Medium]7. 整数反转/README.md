# 7. 整数反转

## Java

```Java
class Solution {
    public int reverse(int x) {
        int num = x;
        int res = 0;
        while(num != 0) {
            int tmp = num % 10;
            if(res > 214748364 || (res == 214748364 && tmp > 7)) {
                return 0;
            }
            if(res < -214748364 ||(res == -214748364 && tmp > 8)) {
                return 0;
            }
            res = res * 10 + tmp;
            num /= 10;
        }
        return res;
    }
}
```