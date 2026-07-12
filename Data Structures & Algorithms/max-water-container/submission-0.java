class Solution {
    public int maxArea(int[] heights) {
        int maxArea = 0;
        int n = heights.length;
        int low = 0;
        int high = n - 1;

        while(low < high){
            int width = high - low;
            int height = Math.min(heights[low], heights[high]);

            int area = height * width;
            maxArea = Math.max(maxArea, area);
            if(heights[low] < heights[high]){
                low++;
            }else{
                high--;
            }
        }
        return maxArea;
    }
}
