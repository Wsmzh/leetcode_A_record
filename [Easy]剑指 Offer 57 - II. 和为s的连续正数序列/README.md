# 剑指 Offer 57 - II. 和为s的连续正数序列

## Java

```Java
class Solution {
    public int[][] findContinuousSequence(int target) {
        int left = 1, right = 2, sum = 3;
        List<int[]> res = new ArrayList<>();
        while(left < right) {
            if(sum == target) {
                int[] ele = new int[right - left + 1];
                for(int i = left ; i <= right ; i ++) {
                    ele[i - left] = i;
                }
                res.add(ele);
                sum -= left;
                left ++;
            } else if(sum < target) {
                sum += right + 1;
                right ++;
            } else {
                sum -= left;
                left ++;
            }
        }

        return res.toArray(new int[res.size()][]);
    }
}
```