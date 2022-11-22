# 387. 字符串中的第一个唯一字符

## Java

```Java
class Solution {
    public int firstUniqChar(String s) {
        Map<Character, Integer> map = new HashMap<>();
        // 第一遍遍历用hashmap记录每一个字符出现的频率
        for(char c : s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // 第二次遍历当遍历到第一个频率为1的字符时，直接返回
        for(int i = 0 ; i < s.length() ; i ++){
            char c = s.charAt(i);
            if(map.get(c) == 1){
                return i;
            }
        }
        // 不存在则返回-1
        return -1;
    }
}
```