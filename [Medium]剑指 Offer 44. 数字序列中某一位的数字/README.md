# 剑指 Offer 44. 数字序列中某一位的数字

## Java

```Java
class Solution {
    public int findNthDigit(int n) {
        int digit = 1;
        long start = 1;
        long count = 9;
        while (n > count) { // 1.
            n -= count;
            digit += 1;
            start *= 10;
            count = digit * start * 9;
        }
        // 推到出的数学规律
        long num = start + (n - 1) / digit; // 2.
        // 使用与上面这个同样的规律
        return Long.toString(num).charAt((n - 1) % digit) - '0'; // 3.
    }
}

```