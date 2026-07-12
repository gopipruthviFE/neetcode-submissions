class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Stack<Integer> st = new Stack<>();
        int maxArea = 0;

        for(int i=0;i<=n;i++){
            int currHeight = i == n ? 0 : heights[i];
            while(!st.isEmpty() && heights[st.peek()] > currHeight){
                int right_boundary = i;
                int curr_bar = st.pop();
                int left_boundary = st.isEmpty() ? -1 : st.peek();
                maxArea = Math.max(maxArea, (right_boundary - left_boundary - 1) * heights[curr_bar]);
            }
            st.push(i);
        }

        return maxArea;
    }
}
