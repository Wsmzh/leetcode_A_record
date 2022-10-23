# 438. 找到字符串中所有字母异位词

## C++

```C++
class Solution {
public:
    vector<int> findAnagrams(string s, string p) {
        unordered_map<char, int> need, window;
        for(char c : p) need[c] ++;

        int left = 0, right = 0;
        int valued = 0;
        vector<int> res;

        while(right < s.size()) {
            char c = s[right];
            right ++;

            if(need.count(c)) {
                window[c] ++;
                if(window[c] == need[c]) {
                    valued ++;
                }
            }

            while(right - left >= p.size()) {
                if(valued == need.size()) {
                    res.push_back(left);
                }
                char d = s[left];
                left ++;
                if(need.count(d)) {
                    if(window[d] == need[d]) {
                        valued --;
                    }
                    window[d] --;
                }
            }
        }
        return res;
    }
};
```