# 剑指 Offer 66. 构建乘积数组

## Java

```Java
class Solution {
    public int[] constructArr(int[] a) {
        int n = a.length;

        if(n == 0) {
            return new int[0];
        }

        // 除了i以外，左边所有的数的乘积
        int[] left = new int[n];
        // 除了i以外，右边所有的数的乘积
        int[] right = new int[n];

        left[0] = 1;
        right[n - 1] = 1;

        int leftRes = 1;
        for(int i = 1 ; i < n ; i ++) {
            leftRes *= a[i - 1];
            left[i] = leftRes;
        }
        int rightRes = 1;
        for(int j = n - 2 ; j >= 0 ; j --) {
            rightRes *= a[j + 1];
            right[j] = rightRes;
        }

        int[] res = new int[n];
        for(int i = 0 ; i < n ; i ++) {
            res[i] = left[i] * right[i];
        }
        return res;
    }
}
```