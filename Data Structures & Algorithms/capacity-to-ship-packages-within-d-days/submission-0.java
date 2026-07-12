class Solution {
    public int func(int capacity, int[] weights){
        int days = 1;
        int w = 0;

        for(int i=0;i<weights.length;i++){
            if(w + weights[i] <= capacity){
                w += weights[i];
            }else{
                days++;
                w = weights[i];
            }
        }

        return days;
    }
    public int shipWithinDays(int[] weights, int days) {
        int n = weights.length;

        int low = 0;
        int high = 0;
        int ans = 0;

        for(int i=0;i<n;i++){
            low = Math.max(low, weights[i]);
            high += weights[i];
        }

        while(low <= high){
            int mid = low + (high - low) / 2;

            int D = func(mid, weights);

            if(D <= days){
                ans = mid;
                high = mid - 1;//try lower capacity
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }

    // Time : O(Wlogn)
}