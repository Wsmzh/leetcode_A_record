# 剑指 Offer 50. 第一个只出现一次的字符

## Java

```Java
class Solution {
    public char firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();

        // 第一遍遍历记录每个字符出现的频次
        for(char c : s.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        // 第二次遍历直接返回
        for(char c : s.toCharArray()) {
            if(map.get(c) == 1) {
                return c;
            }
        }

        return ' ';
    }
}
```