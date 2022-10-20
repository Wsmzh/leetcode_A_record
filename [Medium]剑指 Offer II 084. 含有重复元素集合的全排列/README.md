# 剑指 Offer II 084. 含有重复元素集合的全排列

## Java

```Java
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backtrack(nums);
        return res;
    }

    void backtrack(int[] nums) {
        if(track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return ;
        }

        for(int i = 0 ; i < nums.length ; i ++) {
            if(used[i]) {
                continue ;
            }

            // 剪枝策略，使相同的元素按照原来的顺序存在于新生成的排列中
            if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]){
                continue;
            }

            track.addLast(nums[i]);
            used[i] = true;
            backtrack(nums);
            track.removeLast();
            used[i] = false;
        }
    }
}
```