# 面试题 01.02. 判定是否互为字符重排

## Java

```Java
class Solution {
    public boolean CheckPermutation(String s1, String s2) {
        if(s1.length() != s2.length()) {
            return false;
        }
        if(s1.length() == 0 && s2.length() == 0) {
            return true;
        }
        // 转变为数组
        char[] arr1 = s1.toCharArray();
        char[] arr2 = s2.toCharArray();

        // 排序
        Arrays.sort(arr1);
        Arrays.sort(arr2);

        // 遍历一遍
        for(int i = 0 ; i < arr1.length ; i ++){
            if(arr1[i] != arr2[i]) {
                return false;
            }
        }
        return true;
    }
}
```