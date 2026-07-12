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

public class Codec {

    // Encodes a tree to a single string.
    public void dfs(TreeNode root, StringBuilder sb){
        if(root == null){
            sb.append("null,");
            return;
        }

        sb.append(root.val + ",");
        dfs(root.left, sb);
        dfs(root.right, sb);
    }
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        dfs(root, sb);
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode build(Queue<String> que){
        String value = que.poll();

        if(value.equals("null")){
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(value));
        root.left = build(que);
        root.right = build(que);

        return root;
    }
    public TreeNode deserialize(String data) {
        String[] nodes = data.split(",");

        Queue<String> que = new LinkedList<>(Arrays.asList(nodes));
        TreeNode root = build(que);
        return root;
    }
}
