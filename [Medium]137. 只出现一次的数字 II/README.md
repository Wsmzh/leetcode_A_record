# 137. 只出现一次的数字 II

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

        int res = 0;
        for(int i = 0 ; i < 32 ; i ++) {
            res <<= 1;
            if(k[31 - i] % 3 != 0) {
                res |= 1;
            }
        }

        return res;
    }
}
```