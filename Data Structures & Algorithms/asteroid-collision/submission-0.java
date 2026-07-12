class Solution {
    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> st = new Stack<>();

        for(int i=0;i<asteroids.length;i++){
            boolean alive = true;
            while(!st.isEmpty() && asteroids[i] < 0  && st.peek() > 0 && alive){
                int topAsteroid = st.peek();
                if(topAsteroid == -asteroids[i]){
                    st.pop();
                    alive = false;
                }else if(topAsteroid < -asteroids[i]){
                    st.pop();
                }else{
                    alive = false;
                }
            }
            if(alive){
                st.add(asteroids[i]);
            }
        }

        int n = st.size();
        int idx = n - 1;
        int[] res = new int[n];

        while(idx >= 0){
            res[idx] = st.pop();
            idx--;
        }

        return res;
    }

    // Time : O(n) <--> as each element enters stack once and leaves once
    // Space : O(n) <--> as we store n elements in the stack in the worst case
}