# 2351. 第一个出现两次的字母

## Java

```Java
class Solution {
    public char repeatedCharacter(String s) {
        Set<Character> set = new HashSet<>();
        for(int i = 0 ; i < s.length() ; i ++) {
            char c = s.charAt(i);
            if(!set.add(c)) {
                return c;
            }
        }
        return ' ';
    }
}
```