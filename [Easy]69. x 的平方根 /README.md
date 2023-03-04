# 69. x 的平方根 

## Java

```Java
class Solution {
    public int mySqrt(int x) {
        // 特判
        if(x == 0) {
            return 0;
        }
        if(x == 1) {
            return 1;
        }

        int left = 1;
        int right = x / 2;

        while(left < right) {
            // mid向上取整
            int mid = left + (right - left + 1) / 2;
            if( mid > x / mid) {
                right = mid - 1;
            } else if(mid == x / mid) {
                return mid;
            } else {
                left = mid;
            }biye
        }
        return left;

    }
}
```