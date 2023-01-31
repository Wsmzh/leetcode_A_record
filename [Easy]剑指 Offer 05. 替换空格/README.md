# 剑指 Offer 05. 替换空格

## Java

```Java
class Solution {
    public String replaceSpace(String s) {
        StringBuilder sb = new StringBuilder();
        int n = s.length();
        for(int i = 0 ; i < n ; i ++) {
            if(s.charAt(i) == ' ') {
                sb.append("%20");
            } else {
                sb.append(s.charAt(i));
            }
        }
        return sb.toString();
    }
}
```