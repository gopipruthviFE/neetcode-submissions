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
    public TreeNode buildBT(int[] preOrder,Map<Integer, Integer> map, int start, int end){
        if(start > end){
            return null;
        }

        int rootVal = preOrder[idx++];
        TreeNode root = new TreeNode(rootVal);
        int splitIdx = map.get(rootVal);

        root.left = buildBT(preOrder, map, start, splitIdx - 1);
        root.right = buildBT(preOrder, map, splitIdx + 1, end);

        return root;
    }
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int n = preorder.length;
        Map<Integer, Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            map.put(inorder[i], i);
        }
        TreeNode root = buildBT(preorder, map, 0, n - 1);
        return root;
    }
}
