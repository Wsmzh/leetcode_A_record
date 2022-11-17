# 剑指 Offer 59 - I. 滑动窗口的最大值

## Java

```Java
class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        // 首先定义结果链表
        List<Integer> res = new ArrayList<>();

        // 滑动窗口
        int left = 0, right = 0;

        // 定义双向队列，我们要保证双向队列是非严格递减的
        Deque<Integer> deque = new LinkedList<>();

        while(right < nums.length) {
            // 增大窗口
            int newNumber = nums[right];
            right ++;

            // 窗口中新增加了一个数，则需要把双段队列中，小于它的数都删掉
            while (!deque.isEmpty() && deque.peekLast() < newNumber){
                deque.removeLast();
            }
            // 再将它加入到链表尾部
            deque.addLast(newNumber);

            // 缩小窗口
            if(right - left  == k) {
                // 缩小窗口时，添加最大值到结果链表中
                res.add(deque.peekFirst());
                int deletedNumber = nums[left];
                left ++;
                // 如果删掉的这个数等于最大值，则需要重新找最大值，双向链表表头就是次大值
                if(deletedNumber == deque.peekFirst()) {
                    deque.removeFirst();
                }
            }
        }
        int n = res.size();
        int[] resArr = new int[n];
        for(int i = 0 ; i < n ; i ++) {
            resArr[i] = res.get(i);
        }
        return resArr;
    }
}
```