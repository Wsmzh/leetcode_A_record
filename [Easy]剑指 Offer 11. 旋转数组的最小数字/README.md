# 剑指 Offer 11. 旋转数组的最小数字

## Java

```Java
class Solution {
    public int minArray(int[] numbers) {
        int l = 0, r = numbers.length - 1;

        while(l < r) {
            int m = (l + r) / 2;
            if(numbers[m] > numbers[r]) {
                l = m + 1;
            } else if(numbers[m] < numbers[r]) {
                r = m;
            } else {
                r --;
            }
        }
        return numbers[l];
    }
}
```