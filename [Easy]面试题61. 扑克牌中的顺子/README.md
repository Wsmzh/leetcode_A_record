# 面试题61. 扑克牌中的顺子

## Java

```Java
class Solution {
    public boolean isStraight(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        for(int num : nums) {
            if(num == 0) {
                continue;
            }
            if(set.contains(num)) {
                return false;
            }
            set.add(num);
            min = Math.min(min, num);
            max = Math.max(max, num);
        }
        
        if(max - min + 1 <= 5) {
            return true;
        } else {
            return false;
        }
    }
}
```