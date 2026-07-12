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
    public List<Integer> reverse(List<Integer> list){
        int low = 0;
        int high = list.size() - 1;

        while(low < high){
            int temp = list.get(low);
            list.set(low, list.get(high));
            list.set(high, temp);
            low++;
            high--;
        }

        return list;
    }
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<>();
        if(root == null){
            return res;
        }
        Queue<TreeNode> que = new LinkedList<>();
        que.offer(root);
        int count = 0;

        while(!que.isEmpty()){
            int size = que.size();
            List<Integer> list = new ArrayList<>();

            for(int i=0;i<size;i++){
                TreeNode node = que.poll();
                list.add(node.val);

                if(node.left != null){
                    que.add(node.left);
                }
                if(node.right != null){
                    que.add(node.right);
                }
            }

            if(count % 2 == 0){
                res.add(list);
            }else{
                res.add(reverse(list));
            }
            count++;
        }

        return res;
    }

    // Time : O(n)
}