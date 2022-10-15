# 78. 子集

## Java

```Java
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    // 记录回溯递归算法的路径
    LinkedList<Integer> track = new LinkedList<>();
    public List<List<Integer>> subsets(int[] nums) {
        backtrack(nums, 0);
        return res;
    }

    // start存在即对选择做出限制
    void backtrack(int[] nums, int start) {
        // 前序位置，每一个节点的值都是一个子集
        res.add(new LinkedList<>(track));

        // 回溯算法标准框架
        for(int i = start ; i < nums.length ; i ++) {
            // 做选择
            track.addLast(nums[i]);
            // 通过start参数控制树枝的遍历，避免产生重复的子集
            backtrack(nums, i + 1);
            // 撤销选择
            track.removeLast();
        }
    }
}
```