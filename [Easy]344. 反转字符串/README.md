# 344. 反转字符串

**#左右指针**

## Java

```Java
class Solution {
    public void reverseString(char[] s) {
        // 左右指针
        int left = 0, right = s.length - 1;

        while(left < right) {
            char temp = s[left];
            s[left] = s[right];
            s[right] = temp;
            left ++;
            right --;
        }
    }
}
```