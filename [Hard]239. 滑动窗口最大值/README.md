# 239. 滑动窗口最大值

## Java

```Java
class Solution {
    // 内部类实现一个单调队列
    class MonotonicQueue {
        // 需要一个LinkedList
        LinkedList<Integer> q = new LinkedList<>();

        public void push(int x) {
            while(!q.isEmpty() && q.getLast() < x) {
                q.pollLast();
            }
            q.addLast(x);
        }

        public int max() {
            return q.getFirst();
        }

        public void poll(int x) {
            if(x == q.getFirst()) {
                q.pollFirst();
            }
        }
    }
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 单调队列表示窗口中的最大值列表
        MonotonicQueue window = new MonotonicQueue();
        List<Integer> res = new ArrayList<>();

        for(int i = 0 ; i < nums.length ; i ++) {
            // 先把前k - 1个数加入
            if(i < k - 1) {
                window.push(nums[i]);
            } else {
                // 在加入第k个数时，记录下当前窗口中的最大值
                window.push(nums[i]);
                res.add(window.max());
                // 随后把最左边的值移出窗口
                window.poll(nums[i - k + 1]);
            }
        }
        int[] ans = new int[res.size()];
        for(int i = 0 ; i < ans.length ; i ++) {
            ans[i] = res.get(i);
        }
        return ans;
    }
}
```