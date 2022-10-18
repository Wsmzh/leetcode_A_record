# 39. 组合总和

## Java

```Java
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    // 路径
    LinkedList<Integer> track = new LinkedList<>();
    // 路径中元素和
    int canSum = 0;
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        backtrack(candidates, target, 0);
        return res;
    }

    void backtrack(int[] candidates, int target, int start) {
        // 终止条件
        if(canSum > target) {
            return ;
        }

        // base case
        if(canSum == target) {
            res.add(new LinkedList<>(track));
            return ;
        }

        // 选择
        for(int i = start ; i < candidates.length ; i ++) {
            track.addLast(candidates[i]);
            canSum += candidates[i];
            backtrack(candidates, target, i);
            track.removeLast();
            canSum -= candidates[i];
        }
    }
}
```