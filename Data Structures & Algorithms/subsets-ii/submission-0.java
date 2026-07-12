class Solution {
    public void backtrack(int start, int[] nums, List<List<Integer>> res, List<Integer> list){
        res.add(new ArrayList<>(list));

        for(int i=start;i<nums.length;i++){
            if(i > start && nums[i - 1] == nums[i]){
                continue;
            }
            list.add(nums[i]);
            backtrack(i + 1, nums, res, list);
            list.remove(list.size() - 1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, nums, res, new ArrayList<>());
        return res;
    }

    // Time : O(nlogn) + O(2 ^ (n - TotalNumberOfDuplicateElements + (1 * numberOfDuplicateElements)) * n)
    // Space : O(n)
}
