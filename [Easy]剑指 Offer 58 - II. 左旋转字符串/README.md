# 剑指 Offer 58 - II. 左旋转字符串

## Java

```Java
class Solution {
    public String reverseLeftWords(String s, int n) {
        char[] arr = s.toCharArray();
        // 先reverse前n个字符
        reverse(arr, 0, n - 1);
        // 在reverse后面所有字符
        reverse(arr, n, arr.length - 1);
        // 再将整个进行reverse
        reverse(arr, 0, arr.length - 1);
        return new String(arr);
    }

    private void reverse(char[] arr, int left, int right) {
        while(left < right) {
            char tmp = arr[left];
            arr[left] = arr[right];
            arr[right] = tmp;
            left ++;
            right --;
        }
    }
}
```