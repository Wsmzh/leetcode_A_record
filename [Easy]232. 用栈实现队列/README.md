# 232. 用栈实现队列

## Java

```Java
class MyQueue {

    Stack<Integer> A;
    Stack<Integer> B;

    public MyQueue() {
        A = new Stack<>();
        B = new Stack<>();
    }
    
    public void push(int x) {
        A.push(x);
    }
    
    public int pop() {
        if(!B.isEmpty()) {
            return B.pop();
        } else {
            while(!A.isEmpty()) {
                B.push(A.pop());
            }
            return B.pop();
        }

    }
    
    public int peek() {
        if(!B.isEmpty()) {
            return B.peek();
        } else {
            while(!A.isEmpty()) {
                B.push(A.pop());
            }
            return B.peek();
        }
    }
    
    public boolean empty() {
        if(A.isEmpty() && B.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
```