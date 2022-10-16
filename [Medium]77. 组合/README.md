# 77. 组合

## Java

```Java
class Solution {

    // 记录组合结果
    List<List<Integer>> res = new LinkedList<>();
    // 记录路径
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(1, n, k);
        return res;
    }

    void backtrack(int start, int n, int k) {
        // base case
        if(track.size() == k) {
            res.add(new LinkedList<>(track));
            return ;
        }

        // 做选择
        for(int i = start ; i <= n ; i ++) {
            track.addLast(i);
            backtrack(i + 1, n, k);
            track.removeLast();
        }
    }
}
```