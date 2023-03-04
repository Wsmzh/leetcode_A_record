# 22. 括号生成

## Java

```Java
class Solution {
    List<String> res;
    StringBuilder track;
    public List<String> generateParenthesis(int n) {
        // 记录结果
        res = new ArrayList<>();
        // 记录回溯过程中的路径
        track = new StringBuilder();

        // 特判
        if(n == 0) {
            return res;
        }

        // 进行回溯
        backtrack(n, n);
        return res;
    }

    // 参数中的left和right代表左右括号还剩几个能用
    private void backtrack(int left, int right) {
        // 如果剩的左括号比右括号多，肯定是非法的
        if(right < left) {
            return ;
        }

        // 如果剩余括号数量小于0肯定也是非法的
        if(left < 0 || right < 0) {
            return ;
        }

        // 如果剩余左右括号数量都正好为0，说明是一个合法的新的组合
        if(left == 0 && right == 0) {
            res.add(track.toString());
            return ;
        }

        // 回溯过程
        // 尝试放一个左括号
        track.append('(');
        backtrack(left - 1, right);
        track.deleteCharAt(track.length() - 1); // 撤销选择
        
        // 尝试放一个右括号
        track.append(')');
        backtrack(left, right - 1);
        track.deleteCharAt(track.length() - 1); // 撤销选择

    }
}
```