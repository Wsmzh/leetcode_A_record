# 剑指 Offer II 080. 含有 k 个元素的组合

## Java

```Java
class Solution {
    List<List<Integer>> res = new LinkedList<>();
    LinkedList<Integer> track = new LinkedList<>();

    public List<List<Integer>> combine(int n, int k) {
        backtrack(1, n, k);
        return res;
    }

    void backtrack(int start, int n, int k) {
        if(track.size() == k) {
            res.add(new LinkedList<>(track));
            return ;
        }

        for(int i = start ; i <= n ; i ++) {
            track.addLast(i);
            backtrack(i + 1, n, k);
            track.removeLast();
        }
    }
}
```