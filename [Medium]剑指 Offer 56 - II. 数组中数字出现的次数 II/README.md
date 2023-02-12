# 剑指 Offer 56 - II. 数组中数字出现的次数 II

## Java

```Java
class Solution {
    public int singleNumber(int[] nums) {
        int[] k = new int[32];
        for(int num : nums) {
            for(int i = 0 ; i < 32 ; i ++) {
                k[i] += num & 1;
                num >>= 1;
            }
        }

        int res = 0, m = 3;
        for(int i = 0 ; i < 32 ; i ++) {
            res <<= 1;
            if(k[31 - i] % m != 0) {
                res |= 1;
            }
        }
        return res;
    }
}
```