class Solution {
    public void backtrack(int start, int n, int[] nums, int sum, int target, List<List<Integer>> res, List<Integer> list){
        if(sum == target){
            res.add(new ArrayList<>(list));
            return;
        }
        if(sum > target){
            return;
        }
        for(int i=start;i<n;i++){
            list.add(nums[i]);
            sum += nums[i];
            backtrack(i, n, nums, sum, target, res, list);
            sum -= nums[i];
            list.remove(list.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        int n = nums.length;
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, n, nums, 0, target, res, new ArrayList<>());
        return res;
    }

    // Time: O( n ^ (t / m) * t / m)
    // Space : O(t / m)
}
