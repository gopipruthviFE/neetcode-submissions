class Solution {
    public boolean isValid(String s) {
        int n = s.length();
        Stack<Character> st = new Stack<>();

        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{'){
                st.push(ch);
            }else if(!st.isEmpty() &&
                (
                (st.peek() == '(' && s.charAt(i) == ')') ||
                (st.peek() == '[' && s.charAt(i) == ']') ||
                (st.peek() == '{' && s.charAt(i) == '}')
                )
            ){
                st.pop();
            }else{
                return false;
            }
        }

        return st.isEmpty() ? true : false;
    }
    // Time : O(n) <--> as we check each char only once
    // Space : O(n) <--> as we use stack to store the chars
}
