# 238. 除自身以外数组的乘积

## Java

```Java
class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        int p = 1, q = 1;
        for(int i = 0 ; i < n ; i ++) {
            res[i] = p;
            p *= nums[i];
        }
        for(int i = n - 1 ; i > 0 ; i --) {
            q *= nums[i];
            res[i - 1] *= q;
        }

        return res;
    }
}
```