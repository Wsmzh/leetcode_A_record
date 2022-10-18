# 47. 全排列 II

## Java

```Java
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    // 路径
    LinkedList<Integer> track = new LinkedList<>();
    // 标记是否被添加入路径
    boolean[] used;
    public List<List<Integer>> permuteUnique(int[] nums) {
        // 先对数组进行排序
        Arrays.sort(nums);
        used = new boolean[nums.length];
        backtrack(nums);
        return res;
    }

    void backtrack(int[] nums) {
        // base case
        if(track.size() == nums.length) {
            res.add(new LinkedList<>(track));
            return ;
        }

        // 选择
        for(int i = 0 ; i < nums.length ; i ++) {
            if(used[i] == true) {
                continue;
            }

            // 剪枝的约束条件，思路是保证相同元素的出现顺序
            if(i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
                continue;
            }

            // 做出选择
            track.addLast(nums[i]);
            used[i] = true;
            backtrack(nums);
            // 撤销选择
            track.removeLast();
            used[i] = false;
        }
    }
}
```