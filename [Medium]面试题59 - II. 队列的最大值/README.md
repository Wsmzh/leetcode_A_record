# 面试题59 - II. 队列的最大值

## Java

```Java
class MaxQueue {

    Queue<Integer> queue;
    Deque<Integer> maxQ;

    public MaxQueue() {
        queue = new LinkedList<>();
        maxQ = new LinkedList<>();
    }
    
    public int max_value() {
        return maxQ.isEmpty() ? -1 : maxQ.peekFirst();
    }
    
    public void push_back(int value) {
        queue.offer(value);
        while( !maxQ.isEmpty() && maxQ.peekLast() < value) {
            maxQ.pollLast();
        }
        maxQ.offerLast(value);

    }
    
    public int pop_front() {
        if(queue.isEmpty()) {
            return -1;
        }
        if(!maxQ.isEmpty() && queue.peek().equals(maxQ.peekFirst())) {
            maxQ.pollFirst();
        }
        return queue.poll();
    }
}

/**
 * Your MaxQueue object will be instantiated and called as such:
 * MaxQueue obj = new MaxQueue();
 * int param_1 = obj.max_value();
 * obj.push_back(value);
 * int param_3 = obj.pop_front();
 */
```