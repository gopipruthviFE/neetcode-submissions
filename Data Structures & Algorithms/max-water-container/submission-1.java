class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;

        int low = 0;
        int high = heights.length - 1;

        while(low < high){
            int len = high - low;// only in between length
            int height = Math.min(heights[low], heights[high]);

            int area = len * height;
            maxArea = Math.max(area, maxArea);

            if(heights[low] <= heights[high]){
                low++;
            }else{
                high--;
            }
        }

        return maxArea;
    }

    // Time : O(n) <--> as we check each item only once
    // Space : O(1) <--> no additional space is used
}
