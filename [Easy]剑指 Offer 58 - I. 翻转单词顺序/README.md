# 剑指 Offer 58 - I. 翻转单词顺序

## Java

```Java
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        // 清洗数据
        for(int i = 0 ; i < s.length() ; i ++) {
            char c = s.charAt(i);
            // 不是空格则添加数据
            if(c != ' '){
                sb.append(c);
            } else if(!sb.isEmpty() && sb.charAt(sb.length() - 1) != ' ') {
                // 是空格则保证不能空时加空格和连续空格
                sb.append(' ');
            }
        }
        // 如果末尾有空格
        if(sb.length() != 0 && sb.charAt(sb.length() - 1) == ' ') {
            sb.deleteCharAt(sb.length() - 1);
        }

        char[] res = sb.toString().toCharArray();
        int n = res.length;
        // 全部反转
        reverse(res, 0, n - 1);

        for(int i = 0 ; i < n ;) {
            for(int j = i ; j < n ; j ++) {
                if(j + 1 == n || res[j + 1] == ' ') {
                    reverse(res, i, j);
                    i = j + 2;
                    break;
                }
            }
        }
        return new String(res);
    }

    private void reverse(char[] arr, int i, int j) {
        while(i < j) {
            char tmp = arr[i];
            arr[i] = arr[j];
            arr[j] = tmp;
            i ++;
            j --;
        }
    }
}
```