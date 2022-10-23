# 567. 字符串的排列

## C++

```C++
class Solution {
public:
    // 判断s2是否包含s1的排列，即s1的排列之一是s2的子串
    bool checkInclusion(string s1, string s2) {
        unordered_map<char, int> need, window;
        for(char c : s1) need[c] ++;

        int left = 0, right = 0;
        int valued = 0;

        while(right < s2.size()) {
            char c = s2[right];
            // 扩大窗口
            right ++;
            if(need.count(c)) {
                window[c] ++;
                if(window[c] == need[c]){
                    valued ++;
                }
            }

            // 判断左侧窗口是否要收缩
            while(right - left >= s1.size()) {
                // 这道题[left, right)维护的是一个定长数组
                if(valued == need.size()) {
                    return true;
                }
                char d = s2[left];
                left ++;
                if(need.count(d)) {
                    if(window[d] == need[d]){
                        valued --;
                    }
                    window[d] --;
                }
            }
        }
        return false;
    }
};
```