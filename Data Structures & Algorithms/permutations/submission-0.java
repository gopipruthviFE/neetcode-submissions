class Solution {
    public void backtrack(int start, int[] nums, List<List<Integer>> res, List<Integer> list, Set<Integer> seen){
        if(list.size() == nums.length){
            res.add(new ArrayList(list));
            return;
        }

        for(int i=0;i<nums.length;i++){
            if(seen.contains(nums[i])){
                continue;
            }
            seen.add(nums[i]);
            list.add(nums[i]);
            backtrack(i + 1, nums, res, list, seen);
            list.remove(list.size() - 1);
            seen.remove(nums[i]);
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new ArrayList<>(), new HashSet<>());
        return res;
    }

    // Time : O(n! * n)
    // Space : O(n)
}
