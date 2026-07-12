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
    public TreeNode buildBT(int[] preOrder, int[] inOrder, int start, int end, Map<Integer, Integer> inOrderMap){
        if(start > end){
            return null;
        }

        int rootVal = preOrder[idx++];
        TreeNode root = new TreeNode(rootVal);
        int splitIdx = inOrderMap.get(rootVal);

        root.left = buildBT(preOrder, inOrder, start, splitIdx - 1, inOrderMap);
        root.right = buildBT(preOrder, inOrder, splitIdx + 1, end, inOrderMap);

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> inOrderMap = new HashMap<>();

        for(int i=0;i<inorder.length;i++){
            inOrderMap.put(inorder[i], i);
        }

        TreeNode root = buildBT(preorder, inorder, 0 , preorder.length - 1, inOrderMap);
        return root;
    }
}
