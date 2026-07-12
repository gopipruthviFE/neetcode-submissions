class Solution {
    public int func(int mid, int[] piles){
        int hours = 0;

        for(int i=0;i<piles.length;i++){
            hours += (piles[i] + mid - 1) / mid;
        }
        return hours;
    }
    public int minEatingSpeed(int[] piles, int h) {
        int n = piles.length;
        int low = 1;
        int high = 0;
        int ans = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            high = Math.max(high, piles[i]);
        }

        while(low <= high){
            int mid = low + (high - low) / 2;
            int hours = func(mid, piles);

            if(hours <= h){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        return ans;
    }
}
