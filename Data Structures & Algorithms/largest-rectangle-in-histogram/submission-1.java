class Solution {
    public int largestRectangleArea(int[] heights) {
       // monotonically increasing values in stack
       // store indeces in stack for easier width comparitions

       int n = heights.length;
       int maxArea = 0;
       Stack<Integer> st = new Stack<>();

       for(int i=0;i<=n;i++){
        int currHeight = i == n ? 0 : heights[i];
        while(!st.isEmpty() && currHeight < heights[st.peek()]){
            int topIdx = st.pop();
            int width = st.isEmpty() ? i : i - st.peek() - 1;
            int area = heights[topIdx] * width;
            maxArea = Math.max(maxArea, area);
        }
        st.push(i);
       }

       return maxArea;
    }
    // Time : O(n) // as we check each element once and each element enters stack once and leaves once
    // Space : O(n) // as in worst case we store n elements in the stack
}
