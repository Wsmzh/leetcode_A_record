# 241. 为运算表达式设计优先级

## Java

```Java
class Solution {

    // 备忘录优化
    Map<String, List<Integer>> memo = new HashMap<>();

    // 定义：计算算式expression所有可能的运算结果
    public List<Integer> diffWaysToCompute(String expression) {
        if(memo.containsKey(expression)) {
            return memo.get(expression);
        }

        List<Integer> res = new LinkedList<>();
        for(int i = 0 ; i < expression.length() ; i ++) {
            char c = expression.charAt(i);
            // 扫描expression中的运算符
            if(c == '+' || c == '-' || c == '*'){
                // 分
                // 以运算符为中心，分割成两个字符串，分别递归运算
                List<Integer> left = diffWaysToCompute(expression.substring(0, i));
                List<Integer> right = diffWaysToCompute(expression.substring(i + 1));
                // 治
                // 通过子问题的结果，合成原问题的结果
                for(int a : left) {
                    for(int b : right) {
                        if (c == '+') {
                            res.add(a + b);
                        } else if (c == '-') {
                            res.add(a - b);
                        } else if (c == '*') {
                            res.add(a * b);
                        }
                    }
                }
            }
        }

        // base case
        // 如果res为空，说明expression只是一个单纯的数字，没有运算符
        if(res.isEmpty()) {
            res.add(Integer.parseInt(expression));
        }

        // 添加到备忘录
        memo.put(expression, res);

        return res;
    }
}
```