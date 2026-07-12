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
    public TreeNode invertTree(TreeNode root) {
        if(root == null){
            return root;
        }

        //swap left and right branch childs
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;

        //repeat for all childs
        invertTree(root.left);
        invertTree(root.right);

        //once swapped return root node
        return root;
    }
}
