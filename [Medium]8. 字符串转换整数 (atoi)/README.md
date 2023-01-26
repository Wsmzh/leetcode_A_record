# 8. 字符串转换整数 (atoi)

## Java

```Java
class Solution {
    public int myAtoi(String s) {
        int i = 0;

        // 去除前导空格
        while(i < s.length() && s.charAt(i) == ' ') {
            i ++;
        }

        // 声明符号
        int flag = 1;

        // 记录符号
        if(i < s.length() && s.charAt(i) == '-') {
            flag = -1;
            i ++;
        }
        if(i < s.length() && s.charAt(i) == '+') {
            if(flag == -1) {
                return 0;
            }
            i ++;
        }

        // 使用long记录结果，防止溢出
        long cur = 0;

        // 记录整数
        while(i < s.length() && s.charAt(i) >= '0' && s.charAt(i) <= '9') {
            char c = s.charAt(i);
            int n = c - '0';
            cur = cur * 10 + n;
            if(cur > Integer.MAX_VALUE) {
                break;
            }
            i ++;
        }

        // 使用这种方式判断是否int溢出，溢出的话强制类型转换后与原来的数不同
        if((int) cur != cur) {
            return flag == 1 ? Integer.MAX_VALUE : Integer.MIN_VALUE;
        }

        // 整数加符号
        return (int) cur * flag;
    }
}
```