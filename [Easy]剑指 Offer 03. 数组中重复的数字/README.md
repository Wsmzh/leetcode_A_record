# 剑指 Offer 03. 数组中重复的数字

## Java

```Java
class Solution {
    public int findRepeatNumber(int[] nums) {
        Set<Integer> set = new HashSet<>();

        for(int num : nums) {
            if(!set.add(num)) {
                return num;
            }
        }
        return 0;
    }
}
```