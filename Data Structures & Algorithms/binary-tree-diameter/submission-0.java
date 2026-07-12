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
    public int maxDiameter = 0;
    
    public int maxDepth(TreeNode root){
        if(root == null){
            return 0;
        }
        return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
    }
    public void calculateDiameter(TreeNode root){
        if(root == null){
            return;
        }

        int maxLeft = maxDepth(root.left);
        int maxRight = maxDepth(root.right);

        maxDiameter = Math.max(maxDiameter, 1 + maxLeft + maxRight);
        calculateDiameter(root.left);
        calculateDiameter(root.right);
    }
    public int diameterOfBinaryTree(TreeNode root) {
        calculateDiameter(root);
        return maxDiameter - 1;
    }
}
