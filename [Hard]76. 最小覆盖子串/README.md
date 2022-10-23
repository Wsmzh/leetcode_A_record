# 76. 最小覆盖子串

## C++

```C++
class Solution {
public:
    string minWindow(string s, string t) {
        unordered_map<char, int> need, window;
        for(char c : t) need[c] ++;

        int left = 0, right = 0;
        int valued = 0;
        int start = 0, len = INT_MAX;

        while(right < s.size()) {
            char c = s[right];
            // 扩大窗口
            right ++;

            // 扩大窗口后需要进行的操作
            if(need.count(c)) {
                window[c] ++;
                if(window[c] == need[c]){
                    valued ++;
                }
            }

            // 判断是否需要缩小窗口
            while(valued == need.size()) {
                // 先更新可行解
                if(right - left < len){
                    len = right - left;
                    start = left;
                }
                char d = s[left];
                left ++;
                
                // 缩小窗口后需要进行的操作
                if(need.count(d)) {
                    if(window[d] == need[d]) {
                        valued --;
                    }
                    window[d] --;
                }
            }
        }
        return len == INT_MAX ? "" : s.substr(start, len);
    }
};
```