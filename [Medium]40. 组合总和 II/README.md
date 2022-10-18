# 40. 组合总和 II

## Java

```Java
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    // 记录track中的元素之和
    int canSum = 0;

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 排序
        Arrays.sort(candidates);
        backtrack(candidates, target, 0);
        return res;
    }

    void backtrack(int[] candidates, int target, int start) {
        // 如果大于target，则后面无效直接返回
        if(canSum > target) {
            return ;
        }

        // base case
        if(canSum == target) {
            res.add(new LinkedList<>(track));
            return ;
        }

        // 回溯框架
        for(int i = start; i < candidates.length ; i ++) {
            // 剪枝逻辑
            if(i > start && candidates[i] == candidates[i - 1]) {
                continue;
            }

            // 做出选择
            track.addLast(candidates[i]);
            canSum += candidates[i];

            backtrack(candidates, target, i + 1);

            // 撤销选择
            track.removeLast();
            canSum -= candidates[i];
        }


    }
}
```