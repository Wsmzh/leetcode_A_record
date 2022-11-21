# 剑指 Offer 38. 字符串的排列

## Java

```Java
class Solution {
    // 记录结果
    List<String> res = new LinkedList<>();
    // 记录路径
    StringBuilder sb = new StringBuilder();
    // 标记
    boolean[] used;

    public String[] permutation(String s) {
        used = new boolean[s.length()];
        char[] arr = s.toCharArray();
        Arrays.sort(arr);
        backtrack(arr);
        String[] r = res.toArray(new String[res.size()]);
        return r;
    }

    private void backtrack(char[] arr) {
        if(sb.length() == arr.length) {
            res.add(sb.toString());
            return ;
        }

        for(int i = 0 ; i< arr.length ; i ++) {
            if(used[i]) {
                continue;
            }

            // 剪枝策略，使相同的元素按照原来的顺序存在于新生成的排列中
            if(i > 0 && arr[i] == arr[i - 1] && !used[i - 1]){
                continue;
            }

            used[i] = true;
            sb.append(arr[i]);
            backtrack(arr);
            sb.delete(sb.length() - 1, sb.length());
            used[i] = false;
        }
    }
}
```