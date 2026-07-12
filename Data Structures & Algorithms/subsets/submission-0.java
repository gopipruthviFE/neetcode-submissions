class Solution {
    public void backtrack(int start, int[] nums, List<List<Integer>> list, List<Integer> res){
        if(start == nums.length){
            list.add(new ArrayList<>(res));
            return;
        }

        res.add(nums[start]);
        for(int i=start;i<nums.length;i++){
            backtrack(i + 1, nums, list, res);
        }
        res.remove(res.size() - 1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();

        for(int i=0;i<nums.length;i++){
            backtrack(i, nums, list, new ArrayList<>());
        }
        list.add(new ArrayList<>());
        return list;
    }
}
