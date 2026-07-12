class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] preProd = new int[n];
        int[] sufProd = new int[n];
        int[] res = new int[n];
        preProd[0] = 1;
        sufProd[n - 1] = 1;

        for(int i=1;i<n;i++){
            preProd[i] = preProd[i - 1] * nums[i - 1];
        }
        int suffix = nums[n - 1];
        for(int i=n-2;i>=0;i--){
            preProd[i] = suffix * preProd[i];
            suffix = suffix * nums[i];
        }

        return preProd;
    }
}  
