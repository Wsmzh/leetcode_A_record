# 90. 子集 II

## Java

```Java
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    // 路径
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        // 首先对数组进行排序，使得重复元素排列在一起
        Arrays.sort(nums);
        backtrack(nums, 0);
        return res;
    }

    void backtrack(int[] nums, int start) {
        // 在前序位置讲节点的值（路径）加入到res中
        res.add(new LinkedList(track));

        // 选择
        for(int i = start ; i < nums.length ; i ++) {
            // 剪枝
            // 值相同的树枝，只选择第一条
            if(i > start && nums[i] == nums[i - 1]) {
                continue;
            }
            // 做出选择
            track.addLast(nums[i]);
            // 进行进一步递归
            backtrack(nums, i + 1);
            // 撤销选择
            track.removeLast();
        }
    }
}
```