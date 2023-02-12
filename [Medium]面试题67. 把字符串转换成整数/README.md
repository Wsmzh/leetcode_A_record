# 面试题67. 把字符串转换成整数

## Java

```Java
class Solution {
    public int strToInt(String str) {
        // 字符串长度
        int n = str.length();

        // 遍历指针
        int p = 0;

        // 忽略前导空格
        while(p < n && str.charAt(p) == ' ') {
            p ++;
        }
        // 丢弃空格后看一下是否到末尾
        if(p == n) {
            return 0;
        }

        // 默认为正
        int flag = 1;

        // 判断是否有正负号
        if(str.charAt(p) == '-') {
            flag = -1;
            p ++;
        } else if(str.charAt(p) == '+') {
            p ++;
        }
        // 判断是否到末尾
        if(p == n) {
            return 0;
        }

        // 记录结果
        long res = 0;
        while(p < n && '0' <= str.charAt(p) && str.charAt(p) <= '9') {
            res = res * 10 + (str.charAt(p) - '0');
            // 如果大小越界直接跳出
            if(res > Integer.MAX_VALUE) {
                break;
            }
            p ++;
        }

        // 判断是否在int合理范围内
        if((int) res != res) {
            return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }
        
        return (int) res * flag;

    }
}
```