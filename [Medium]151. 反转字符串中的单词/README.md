# 151. 反转字符串中的单词

## Java

```Java
class Solution {
    public String reverseWords(String s) {
        // 对字符串清理
        StringBuilder sb = new StringBuilder();

        for(int i = 0 ; i < s.length() ; i ++) {
            char c = s.charAt(i);
            // 如果是正常字符直接添加
            if(c != ' ') {
                sb.append(c);
            } else if(sb.length() != 0 && sb.charAt(sb.length() - 1) != ' ') {
                // 如果是空格，则只有可能是sb不为空，即单词间空格，且只能添加一个
                sb.append(' ');
            }
        }
        // 去除最后的空格
        if(sb.length() != 0 &&  sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }
        
        // 转为数组
        char[] chars = sb.toString().toCharArray();
        // 将数组反转
        reverse(chars, 0, chars.length - 1);

        // 再逐个将单词反转
        for(int i = 0 ; i < chars.length ; ) {
            for(int j = i ; j < chars.length ; j ++) {
                if(j + 1 == chars.length || chars[j + 1] == ' ') {
                    reverse(chars, i, j);
                    i = j + 2;
                    break;
                }
            }
        }

        String res = new String(chars);
        return res;
    }
    private void reverse(char[] chars, int lo, int hi) {
        while(lo < hi) {
            char temp = chars[lo];
            chars[lo] = chars[hi];
            chars[hi] = temp;
            lo ++;
            hi --;
        }
    }
}
```