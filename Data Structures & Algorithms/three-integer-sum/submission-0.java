class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        int n = nums.length;

        for(int i=0;i<n-2;i++){
            if(i > 0 && nums[i] == nums[i - 1]){
                continue;
            }

            int target = -nums[i];
            int low = i + 1;
            int high = n - 1;

            while(low < high){
                if(nums[low] + nums[high] == target){
                    res.add(Arrays.asList(nums[i], nums[low], nums[high]));
                    low++;
                    high--;

                    while(low < high && nums[low] == nums[low - 1]){
                        low++;
                    }
                    while(low < high && nums[high] == nums[high + 1]){
                        high--;
                    }
                }else if(nums[low] + nums[high] < target){
                    low++;
                }else{
                    high--;
                }
            }
        }

        return res;
    }
}
