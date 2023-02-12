# 剑指 Offer 33. 二叉搜索树的后序遍历序列

## Java

```Java
class Solution {
    public boolean verifyPostorder(int[] postorder) {
        return check(postorder, 0, postorder.length - 1);
    }

    private boolean check(int[] postorder, int i, int j) {
        if(i >= j) {
            return true;
        }

        // 根节点
        int root = postorder[j];

        // 找到左子树的范围
        int left = i;
        while(left < j && postorder[left] < root) {
            left ++;
        }
        // 找到右子树的范围
        int right = left;
        while(right < j && postorder[right] > root) {
            right ++;
        }
        // 在右子树的范围内如果有小于root的则肯定不是后序遍历序列
        if(right != j) {
            return false;
        }

        // 递归遍历左右子树
        return check(postorder, i, left - 1) && check(postorder, left, j - 1);
    }
}
```