# 剑指 Offer 17. 打印从1到最大的n位数

## Java

```Java
class Solution {
    public int[] printNumbers(int n) {
        int size = 1;
        for(int i = 0 ; i < n ; i ++) {
            size *= 10;
        }
        int[] res = new int[size - 1];
        for(int i = 0 ; i < size - 1 ; i ++) {
            res[i] = i + 1;
        }
        return res;
    }
}
```