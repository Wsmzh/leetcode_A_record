# 剑指 Offer II 014. 字符串中的变位词

## C++

```C++
class Solution {
public:
    bool checkInclusion(string s1, string s2) {
        unordered_map<char, int> need, window;
        for(char c : s1) need[c] ++;

        int left = 0, right = 0;
        int valid = 0;
        while(right < s2.size()) {
            char c = s2[right];
            right ++;
            if(need.count(c)){
                window[c] ++;
                if(window[c] == need[c]){
                    valid ++;
                }
            }
            while(right - left >= s1.size()) {
                if(valid == need.size()) {
                    return true;
                }
                char d = s2[left];
                left ++;
                if(need.count(d)){
                    if(window[d] == need[d]){
                        valid --;
                    }
                    window[d] --;
                }
            }
        }
        return false;
    }
};
```

## Java

```Java
// 典型的滑动窗口解决问题
class Solution {
    // 判断s2是否包含s1
    public boolean checkInclusion(String s1, String s2) {
        // 所谓包含就是窗口内的元素种类以及每一个元素的数量都与s1相同
        // 因此定义一个变量记录有几种元素达到满足的条件
        int valid = 0;

        // 定义两个HashMap，分别记录s1中各个元素的数量，和窗口中各个元素的数量
        Map<Character, Integer> need = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();

        // 首先将完善need map
        for(int i = 0 ; i < s1.length() ; i ++) {
            char c = s1.charAt(i);
            if(need.containsKey(c)) {
                need.put(c, need.get(c) + 1);
            } else {
                need.put(c, 1);
            }
        }

        // 定义滑动窗口的左右边界
        int left = 0, right = 0;
        while(right < s2.length()) {
            char c = s2.charAt(right);
            right ++;

            // 如果这个元素在s1中有
            if(need.containsKey(c)) {
                // 窗口中相应元素的出现频次加一
                if(window.containsKey(c)) {
                    window.put(c, window.get(c) + 1);
                } else {
                    window.put(c, 1);
                }
                // 如果该元素频次跟s1中该元素出现的频次相同，则valid + 1
                if(window.get(c).equals(need.get(c))) {
                    valid ++;
                }
            }

            // 判断何时收缩窗口
            while(right - left >= s1.length()) {
                // 满足包含条件返回true
                if(valid == need.size()) {
                    return true;
                }
                char d = s2.charAt(left);
                left ++;
                // 要判断收缩窗口，除去的元素是否是s1中出现的
                if(need.containsKey(d)) {
                    // 并且窗口中该元素出现频次正好跟s1中的出现频次相同的话，因为除去，所以valid - 1
                    if(window.get(d).equals(need.get(d))) {
                        valid --;
                    }
                    // 窗口中该元素的频次减一
                    window.put(d, window.get(d) - 1);
                }
            }
        }

        return false;

    }
}
```