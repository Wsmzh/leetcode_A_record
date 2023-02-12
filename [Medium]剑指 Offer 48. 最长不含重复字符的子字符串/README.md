# 剑指 Offer 48. 最长不含重复字符的子字符串

## Java

```Java
class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) {
            return 0;
        }
        // 记录结果
        int res = 1;
        
        // HashMap记录字符出现的次数
        HashMap<Character, Integer> map = new HashMap<>();
        
        // 滑动窗口的左右边界
        int left = 0, right = 0;
        int n = s.length();
        // 开始滑
        while(right < n) {
            char c = s.charAt(right);
            map.put(c, map.getOrDefault(c, 0) + 1);
            right ++;

            // 当新加了字符导致出现重复时，右移左边界
            while(map.get(c) > 1) {
                char d = s.charAt(left);
                if(map.get(d) == 1) {
                    map.put(d, 0);
                } else {
                    map.put(d, map.get(d) - 1);
                }
                left ++;
            }

            // 这里保证无重复
            int tempLength = right - left;
            res = Math.max(res, tempLength);
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
        int res = 0;
        unordered_map<char, int> window;
        int left = 0, right = 0;
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