# 20. 有效的括号

## Java

```Java
class Solution {
    public boolean isValid(String s) {
        // 辅助栈
        Stack<Character> stack = new Stack<>();

        // 遍历字符串
        for(char c : s.toCharArray()) {
            // 逻辑！
            if(c == '(') {
                stack.push(')');
            } else if(c == '{') {
                stack.push('}');
            } else if(c == '[') {
                stack.push(']');
            } else {
                if(stack.isEmpty() || c != stack.pop()) {
                    return false;
                }
            }
        }

        // 遍历完字符串还是要判断栈内是否有元素
        if(stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}
```