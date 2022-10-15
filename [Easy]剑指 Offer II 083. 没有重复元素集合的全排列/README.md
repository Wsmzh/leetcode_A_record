# 剑指 Offer II 083. 没有重复元素集合的全排列

## Java

```Java
class Solution {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        // 路径
        LinkedList<Integer> track = new LinkedList<>();
        // 选择
        boolean[] used = new boolean[nums.length];
        // 递归
        backtrack(nums, track, used);
        return res;
    }

    void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
        // 结束条件
        if(track.size() == nums.length) {
            res.add(new LinkedList(track));
            return ;
        }
        // 做选择
        for(int i = 0 ; i < nums.length ; i ++) {
            // 不可选
            if(used[i]) {
                continue;
            }
            // 做出选择
            track.add(nums[i]);
            used[i] = true;
            // 下一层递归
            backtrack(nums, track, used);
            // 撤销选择
            track.removeLast();
            used[i] = false;
        }
    }
}
```