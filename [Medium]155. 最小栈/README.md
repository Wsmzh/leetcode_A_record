# 155. 最小栈

## Java

```Java
class MinStack {

    Stack<Integer> workStack;
    Stack<Integer> recordStack;

    public MinStack() {
        workStack = new Stack<>();
        recordStack = new Stack<>();
    }
    
    public void push(int val) {
        workStack.push(val);
        if(recordStack.isEmpty() || val <= recordStack.peek()) {
            recordStack.push(val);
        }
    }
    
    public void pop() {
        int val = workStack.peek();
        workStack.pop();
        if(val == recordStack.peek()) {
            recordStack.pop();
        }
    }
    
    public int top() {
        return workStack.peek();
    }
    
    public int getMin() {
        return recordStack.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */
```