# 剑指 Offer 31. 栈的压入、弹出序列

## Java

```Java
class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        // 辅助栈模拟
        Stack<Integer> stack = new Stack<Integer>();
        int j = 0;
        for(int elem : pushed) {
            stack.push(elem);
            while(j < popped.length && !stack.isEmpty() && stack.peek() == popped[j]) {
                stack.pop();
                j ++;
            }
        }
        return j == popped.length;
    }
}
```