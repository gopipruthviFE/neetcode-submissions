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
    int count = 0;
    public void countNodes(TreeNode root, int value){
        if(root == null){
            return;
        }
        if(root.val >= value){
            count++;
            value = root.val;
        }
        countNodes(root.left, value);
        countNodes(root.right, value);
    }
    public int goodNodes(TreeNode root) {
        countNodes(root, root.val);
        return count;
    }
}
