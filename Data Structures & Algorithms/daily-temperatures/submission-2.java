class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int n = temperatures.length;
        int[] next = new int[n];
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<n;i++){
            while(!st.isEmpty() && temperatures[i] > temperatures[st.peek()]){
                int idx = st.pop();
                next[idx] = i - idx;// this is difference not the number of numbers between them so i - idx
            }
            st.push(i);
        }

        return next;
    }

    // Time : O(n) <--> as we check each element only once and enters stack once and gets removed once
    // Space : O(n) <--> as we have took stack which holds n elements in the worst case 
}
