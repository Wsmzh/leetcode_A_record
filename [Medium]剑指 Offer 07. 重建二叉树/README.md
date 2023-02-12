# 剑指 Offer 07. 重建二叉树

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return build(preorder, 0, preorder.length - 1, inorder, 0, inorder.length - 1);
    }

    public TreeNode build(int[] preorder, int leftStart, int leftEnd, int[] inorder, int rightStart, int rightEnd) {
        if(leftStart > leftEnd || rightStart > rightEnd) {
            return null;
        }
        int rootValue = preorder[leftStart];
        TreeNode root = new TreeNode(rootValue);
        int rootIndex = 0;
        for(int i = rightStart ; i <= rightEnd ; i ++) {
            if(inorder[i] == rootValue) {
                rootIndex = i;
                break;
            }
        }
        int leftLength = rootIndex - rightStart;
        int rightLength = rightEnd - rootIndex;

        root.left = build(preorder, leftStart + 1, leftStart + leftLength, inorder, rightStart, rootIndex - 1);
        root.right = build(preorder, leftStart + leftLength + 1, leftEnd, inorder, rootIndex + 1, rightEnd);
        return root;
    }
}
```