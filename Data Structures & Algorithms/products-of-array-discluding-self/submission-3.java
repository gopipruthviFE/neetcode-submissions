class Solution {
    // public int[] productExceptSelf(int[] nums) {
    //     int n = nums.length;
    //     int[] prefix = new int[n];
    //     int[] suffix = new int[n];
    //     int[] res = new int[n];

    //     // compute prefix product
    //     prefix[0] = 1;

    //     for(int i=1;i<n;i++){
    //         prefix[i] = prefix[i - 1] * nums[i - 1];
    //     }

    //     // compute suffix product

    //     suffix[n - 1] = 1;

    //     for(int i=n-2;i>=0;i--){
    //         suffix[i] = suffix[i + 1] * nums[i + 1];
    //     }

    //     for(int i=0;i<n;i++){
    //         res[i] = prefix[i] * suffix[i];
    //     }

    //     return res;
    // }
    // // Time : O(n) <--> we scan same length of array 3 times 3 * O(n) = O(n)
    // // Space : O(n) <--> as we take 2 additional arrays other than res array

    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];

        // compute prefix product
        res[0] = 1;

        for(int i=1;i<n;i++){
            res[i] = res[i - 1] * nums[i - 1];
        }

        // compute suffix product

        int suffix = 1;

        for(int i=n-2;i>=0;i--){
            // compute suffix
            suffix = nums[i + 1] * suffix;
            // compute prefix * suffix
            res[i] = res[i] * suffix;
        }

        return res;
    }
    // Time : O(n) <--> as we check each element once and compute prefix and suffix product
    // Space : O(1)  <--> no extra arrays are used and output format is int[] so result array is excluded from the space
}  
