# 剑指 Offer 09. 用两个栈实现队列

## Java

```Java
class CQueue {

    LinkedList<Integer> A;
    LinkedList<Integer> B;

    public CQueue() {
        A = new LinkedList<>();
        B = new LinkedList<>();
    }
    
    public void appendTail(int value) {
        A.add(value);
    }
    
    public int deleteHead() {
        if(!B.isEmpty()) {
            return B.removeLast();
        }
        if(A.isEmpty()) {
            return -1;
        }
        while(!A.isEmpty()) {
            B.add(A.removeLast());
        }
        return B.removeLast();
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */
```