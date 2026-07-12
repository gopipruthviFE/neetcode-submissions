class Solution {
    public void backtrack(int start, int[] nums, List<List<Integer>> list, List<Integer> res){
        list.add(new ArrayList<>(res));

        for(int i=start;i<nums.length;i++){
            res.add(nums[i]);
            backtrack(i + 1, nums, list, res);
            res.remove(res.size() - 1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        backtrack(0, nums, list, new ArrayList<>());
        return list;
    }
}
