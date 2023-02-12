# 剑指 Offer 26. 树的子结构

## Java

```Java
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public boolean isSubStructure(TreeNode A, TreeNode B) {
        return (A != null && B != null) && (issub(A, B) || isSubStructure(A.left, B) || isSubStructure(A.right, B));

    }

    private boolean issub(TreeNode A, TreeNode B) {
        if(B == null) {
            return true;
        }
        if(A == null || A.val != B.val) {
            return false;
        }
        return issub(A.left, B.left) && issub(A.right, B.right);


    }
}
```