# 剑指 Offer II 082. 含有重复元素集合的组合

## Java

```Java
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int cndSum = 0;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        // 先排序
        Arrays.sort(candidates);
        backtrack(candidates, target, 0);
        return res;
    }

    void backtrack(int[] candidates, int target, int start) {
        if(cndSum > target) {
            return ;
        }

        if(cndSum == target) {
            res.add(new LinkedList<>(track));
            return ;
        }

        for(int i = start ; i < candidates.length ; i ++) {
            // 剪枝，跳过值相同的相邻树枝
            if(i > start && candidates[i] == candidates[i - 1]) {
                continue ;
            }
            
            track.addLast(candidates[i]);
            cndSum += candidates[i];
            backtrack(candidates, target, i + 1);
            track.removeLast();
            cndSum -= candidates[i];
        }
    }
}
```