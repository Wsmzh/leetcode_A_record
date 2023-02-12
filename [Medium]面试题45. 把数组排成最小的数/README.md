# 面试题45. 把数组排成最小的数

## Java

```Java
class Solution {
    public String minNumber(int[] nums) {
        int n = nums.length;
        String[] strs = new String[n];
        for(int i = 0 ; i < n ; i ++) {
            strs[i] = Integer.toString(nums[i]);
        }
        Arrays.sort(strs, (s1, s2) -> {
            return (s1 + s2).compareTo(s2 + s1);
        });

        return String.join("", strs);
    }
}
```