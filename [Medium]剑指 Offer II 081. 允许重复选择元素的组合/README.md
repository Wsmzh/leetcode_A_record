# 剑指 Offer II 081. 允许重复选择元素的组合

## Java

```Java
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();
    int cndSum = 0;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
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
            track.addLast(candidates[i]);
            cndSum += candidates[i];
            backtrack(candidates, target, i);
            track.removeLast();
            cndSum -= candidates[i];
        }

    }
}
```