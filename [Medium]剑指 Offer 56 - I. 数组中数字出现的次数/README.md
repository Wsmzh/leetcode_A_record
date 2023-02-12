# 剑指 Offer 56 - I. 数组中数字出现的次数

## Java

```Java
class Solution {
    public int[] singleNumbers(int[] nums) {
        // 总的思想是，作区分，然后复用寻找只有一个不同数的方法
        int x = 0, y = 0, n = 0, m = 1;
        for(int elem : nums) {
            n ^= elem;
        }
        while((n & m) == 0) {
            m <<= 1;
        }
        for(int elem : nums) {
            if((elem & m) != 0) x ^= elem;
            else y ^= elem;
        }
        return new int[]{x, y};
    }
}
```