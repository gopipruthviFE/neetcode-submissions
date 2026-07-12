class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int maxLeft = height[0];
        int maxRight = height[n - 1];
        int water = 0;

        int left = 0;
        int right = n - 1;

        while(left < right){
            if(height[left] <= height[right]){
                maxLeft = Math.max(maxLeft, height[left]);
                water += maxLeft - height[left];
                left++;
            }else{
                maxRight = Math.max(maxRight, height[right]);
                water += maxRight - height[right];
                right--;
            }
        }

        return water;
    }

    // Time : O(n) <--> as we check each item only once
    // Space : O(1) <--> no additinal space is used
}
