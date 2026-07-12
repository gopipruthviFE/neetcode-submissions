class Solution {
     public static boolean subsetSum(int n, int[] arr, int sum, Boolean[][] dp){
        if(sum == 0){
            return true;
        }
        if(n == 0){
            return false;
        }
        
        if(dp[n][sum] != null){
            return dp[n][sum];
        }
        
        boolean take = false;
        
        if(arr[n - 1] <= sum){
            take = subsetSum(n - 1, arr, sum - arr[n - 1], dp);
        }
        
        boolean skip = subsetSum(n - 1, arr, sum, dp);
        
        return dp[n][sum] = take || skip;
    }
    public boolean canPartition(int[] nums) {
        // code here
        int n = nums.length;
        int sum = 0;
        
        for(int i=0;i<n;i++){
            sum += nums[i];
        }
        
        if(sum % 2 == 1){
            return false;
        }
        
        sum /= 2;
        
        Boolean[][] dp = new Boolean[n + 1][sum + 1];
        return subsetSum(n, nums, sum, dp); 
    }
}
