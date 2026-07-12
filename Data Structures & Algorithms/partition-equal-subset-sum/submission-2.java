class Solution {
    public boolean partition(int start, int sum, int[] nums, Boolean[] dp){
        if(sum < 0){
            return false;
        }
        if(sum == 0){
            return dp[sum] = true;
        }

        if(dp[sum] != null){
            return dp[sum];
        }

        for(int i=start;i<nums.length;i++){
            if(sum - nums[i] >= 0 && partition(i + 1, sum - nums[i], nums, dp)){
                return dp[sum] = true;
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
        Boolean[] dp = new Boolean[sum + 1];

        return partition(0, sum, nums, dp);
    }
}
