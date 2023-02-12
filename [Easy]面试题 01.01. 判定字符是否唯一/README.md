# 面试题 01.01. 判定字符是否唯一

## Java

```Java
class Solution {
    public boolean isUnique(String astr) {
        // 如果为null直接返回
        if(astr == null) {
            return true;
        }
        // 如果长度大于26直接返回
        if(astr.length() > 26) {
            return false;
        }
        // 转变为数组
        char[] arr = astr.toCharArray();
        // 排序
        Arrays.sort(arr);
        // 相邻的字符比较
        for(int i = 1 ; i < arr.length ; i ++) {
            if(arr[i] == arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
```