# 3. 无重复字符的最长子串

## Java

```Java
class Solution {
    // 滑动窗口 + HashMap
    public int lengthOfLongestSubstring(String s) {
        // 记录结果
        int res = 0;
        // 记录窗口中字符出现的频率
        HashMap<Character, Integer> map = new HashMap<>();
        // 窗口的左右边界
        int left = 0, right = 0;
        // 字符串长度
        int n = s.length();
        // 右边界前进
        while(right < n) {
            char rightWord = s.charAt(right);
            map.put(rightWord, map.getOrDefault(rightWord, 0) + 1);
            right ++;

            // 左边界收缩
            while(map.get(rightWord) > 1) {
                char leftWord = s.charAt(left);
                if(map.get(leftWord) == 1) {
                    map.put(leftWord, 0);
                } else {
                    map.put(leftWord, map.get(leftWord) - 1);
                }
                left ++;
            }

            // 此处窗口内无重复字符，更新结果
            res = Math.max(res, right - left);
        }
        return res;
    }
}
```

## C++

```C++
class Solution {
public:
    int lengthOfLongestSubstring(string s) {
        unordered_map<char, int> window;
        int left = 0, right = 0;
        int res = 0;

        while(right < s.size()) {
            char c = s[right];
            right ++;
            window[c] ++;
            while(window[c] > 1) {
                char d = s[left];
                left ++;
                window[d] --;
            }
            res = max(res, right - left);
        }
        return res;
    }
};
```