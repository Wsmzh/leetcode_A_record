# 557. 反转字符串中的单词 III

## Java

```Java
class Solution {
    public String reverseWords(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        int p1 = 0;
        for(int i = 0 ; i < n ; i ++) {
            if(s.charAt(i) == ' ') {
                for(int j = i - 1 ; j >= p1 ; j --) {
                    sb.append(s.charAt(j));
                }
                sb.append(' ');
                p1 = i + 1;
            } else if (i == n - 1) {
                for(int j = i ; j >= p1 ; j --) {
                    sb.append(s.charAt(j));
                }
            }
            
        }
        
        return sb.toString();
    }
}
```