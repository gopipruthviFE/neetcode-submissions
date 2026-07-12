class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        Stack<Integer> st = new Stack<>();
        int[] next = new int[n];

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                int top = st.pop();
                next[top] = i - top;
            }
            st.push(i);
        }

        return next;
    }
}
