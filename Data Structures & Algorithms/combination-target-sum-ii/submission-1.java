class Solution {
    public void backtrack(int start, int[] candidates, int sum, int target, List<List<Integer>> res, List<Integer> list){
        if(sum == target){
            res.add(new ArrayList<>(list));
            return;
        }
        if(sum > target){
            return;
        }

        for(int i=start;i<candidates.length;i++){
            if(i > start && candidates[i - 1] == candidates[i]){
                continue;
            }
            list.add(candidates[i]);
            sum += candidates[i];
            backtrack(i + 1, candidates, sum, target, res, list);
            sum -= candidates[i];
            list.remove(list.size() - 1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<List<Integer>> res = new ArrayList<>();
        backtrack(0, candidates,0, target, res, new ArrayList<>());
        return res;
    }

    // Time : O(n ^ (t / m) * (t / m))
    // Space : O(t / m)
}
