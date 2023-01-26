# 14. 最长公共前缀

## Java

```Java
class Solution {
    public String longestCommonPrefix(String[] strs) {
        // 可以以第一个String为标准
        String firstStr = strs[0];

        // 记录公共前缀的最后一个字符后的index
        int p = 0;
        
        // 从左到右遍历第一个String
        for(int i = 0 ; i < firstStr.length() ; i ++) {
            // 取出当前位置的字符
            char c = firstStr.charAt(i);

            // 定义一个flag 记录当前位置，是否所有的字符串都有相同字符
            boolean flag = true;

            for(int j = 0 ; j < strs.length ; j ++) {
                if(i < strs[j].length() && strs[j].charAt(i) == c) {
                    // 当前位置有效且字符相等，则看下一个字符串
                    continue;
                } else {
                    // 否则修改flag，标识当前位置有的字符串上的字符不满足相等特点，终止掉循环
                    flag = false;
                    break;
                }
            }

            // 判断flag
            if(flag) {
                p ++;
            } else {
                break;
            }
        }

        // 截取最长公共前缀
        return firstStr.substring(0, p);
    }
}
```