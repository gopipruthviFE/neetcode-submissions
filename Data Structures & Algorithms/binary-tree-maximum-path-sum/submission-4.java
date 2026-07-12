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
    int maxSum = Integer.MIN_VALUE;

    public int findMax(TreeNode root){
        if(root == null){
            return 0;
        }

        int left = findMax(root.left);
        left = left < 0 ? 0 : left;
        int right = findMax(root.right);
        right = right < 0 ? 0 : right;

        int sum = root.val;//start fresh
        sum = Math.max(sum, sum + left + right);// extend
        maxSum = Math.max(maxSum, sum);

        return root.val + Math.max(left, right);// for proper path
    }
    public int maxPathSum(TreeNode root) {
        findMax(root);
        return maxSum;
    }

    // Time : O(n)
    // Space : O(h)
}
