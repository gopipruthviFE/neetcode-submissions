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
    List<Integer> res = new ArrayList<>();
    int level = 0;
    public void traverse(TreeNode root){
        if(root == null){
            return;
        }
        if(res.size() == level){
            res.add(root.val);
        }
        level++;
        traverse(root.right);
        traverse(root.left);
        level--;
    }
    public List<Integer> rightSideView(TreeNode root) {
        traverse(root);
        return res;
    }
}
