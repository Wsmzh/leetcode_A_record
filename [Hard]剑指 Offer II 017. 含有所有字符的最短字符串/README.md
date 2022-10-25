# 剑指 Offer II 017. 含有所有字符的最短字符串

## C++

```C++
class Solution {
public:
    string minWindow(string s, string t) {
        unordered_map<char, int> need, window;
        for(char c : t) need[c] ++;

        int left = 0, right = 0;
        int valid = 0;
        int start = 0, len = INT_MAX;

        while(right < s.size()) {
            char c = s[right];
            right ++;
            if(need.count(c)) {
                window[c] ++;
                if(window[c] == need[c]) {
                    valid ++;
                }
            }

            while(valid == need.size()) {
                if(right - left < len) {
                    start = left;
                    len = right - left;
                }
                char d = s[left];
                left ++;
                if(need.count(d)) {
                    if(window[d] == need[d]){
                        valid --;
                    }
                    window[d] --;
                }
            }
        }

        return len == INT_MAX ? "" : s.substr(start, len);
    }
};
```