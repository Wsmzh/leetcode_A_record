# 剑指 Offer II 016. 不含重复字符的最长子字符串

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