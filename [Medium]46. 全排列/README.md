# 46. 全排列

##  Java

```Java
class Solution {
    List<List<Integer>> res = new LinkedList<>();

    public List<List<Integer>> permute(int[] nums) {
        // 记录路径
        LinkedList<Integer> track = new LinkedList<>();
        // 路径中的元素会被标记为true，避免重复使用
        boolean[] used = new boolean[nums.length];

        backtrack(nums, track, used);
        return res;
    }

    // 路径：记录在track中
    // 选择列表：nums中不存在于track的那些元素（used[i]为false）
    // 结束条件：nums中的元素全部在track中出现
    void backtrack(int[] nums, LinkedList<Integer> track, boolean[] used) {
        // 触发结束条件
        if(track.size() == nums.length) {
            res.add(new LinkedList(track));
            return ;
        }

        for(int i = 0 ; i < nums.length ; i ++) {
            // 排除不合法的选择
            if(used[i] == true) {
                continue;
            }
            // 做选择
            track.add(nums[i]);
            used[i] = true;
            // 进入下一层决策树
            backtrack(nums, track, used);
            // 取消选择
            track.removeLast();
            used[i] = false;
        }
    }
}
```