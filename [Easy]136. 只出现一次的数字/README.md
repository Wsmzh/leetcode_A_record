# 136. 只出现一次的数字

## Java

采用异或的解决方案
异或运算有一个特点：
+ 任何数与本身做异或运算得0
+ 任何数与0做异或运算得该数本身

依据这样的运算性质，使用一个0对数组中所有的数依次做异或运算，这样任何两两成对的数都将得0，最后只出现一次的数字留下来。

```Java
class Solution {
    public int singleNumber(int[] nums) {
        int res = 0;
        for(int num : nums) {
            res ^= num;
        }
        return res;
    }
}
```