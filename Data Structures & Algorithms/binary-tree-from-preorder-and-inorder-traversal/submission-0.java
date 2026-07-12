/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

class Solution {
    int idx = 0;
    public TreeNode buildBT(int[] preOrder, int[] inOrder, int start, int end){
        if(start > end){
            return null;
        }

        int rootVal = preOrder[idx++];
        TreeNode root = new TreeNode(rootVal);
        int splitIdx = 0;

        for(int i=start;i<=end;i++){
            if(rootVal == inOrder[i]){
                splitIdx = i;
                break;
            }
        }

        root.left = buildBT(preOrder, inOrder, start, splitIdx - 1);
        root.right = buildBT(preOrder, inOrder, splitIdx + 1, end);

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;

        TreeNode root = buildBT(preorder, inorder, 0, n - 1);
        return root;
    }
}
