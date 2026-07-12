class Solution {
    public boolean partition(int start, int sum, int[] nums){
        if(sum < 0){
            return false;
        }
        if(sum == 0){
            return true;
        }

        for(int i=start;i<nums.length;i++){
            if(sum - nums[i] >= 0 && partition(i + 1, sum - nums[i], nums)){
                return true;
            }
        }

        return false;
    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;

        for(int num : nums){
            sum += num;
        }

        if(sum % 2 == 1){
            return false;
        }
        sum /= 2;

        return partition(0, sum, nums);
    }
}
