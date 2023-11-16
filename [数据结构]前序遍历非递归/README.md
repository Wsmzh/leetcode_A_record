# 前序遍历非递归

## Java

```Java

class Solution {
    public void preOrder(TreeNode root) {
        Stack<TreeNode> s = new Stack<>();
        TreeNode p = root;

        while(p != null || !s.isEmpty()) {
            while(p != null) {
                System.out.print(p.val);
                s.push(p);
                p = p.left;
            }

            if(!s.isEmpty()) {
                
            }
        }
    }
}

```