class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        Arrays.sort(nums);

        for(int i=0;i<nums.length-2;i++){
            if(i > 0 && nums[i - 1] == nums[i]){// skip duplicate 1st numbers
                continue;
            }
            int target = -nums[i];

            int low = i + 1;
            int high = nums.length - 1;

            while(low < high){
                if(nums[low] + nums[high] == target){
                    res.add(Arrays.asList(nums[low], nums[high], nums[i]));
                    low++;
                    high--;

                    while(low < high && nums[low - 1] == nums[low]){
                        low++;
                    }
                    while(low < high && nums[high + 1] == nums[high]){
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
    // Time : O(n ^ 2 + nLogn) <--> outerloop and inner loop each element is checked atmost twice
    // Space : O(1) <--> no additional space is used here
}
