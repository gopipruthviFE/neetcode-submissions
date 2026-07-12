class Solution {
    public int calculate(String s) {
        int num = 0;
        int sign = '+';
        int val = 0;

        Stack<Integer> st = new Stack<>();

        for(int i=0;i<s.length();i++){
            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                num = num * 10 + (ch - '0');
            }

            if((!Character.isDigit(ch) && ch != ' ') || i == s.length() - 1){
                if(sign == '+'){//ch is not checked here only previous signs
                    st.push(num);
                }else if(sign == '-'){
                    st.push(-num);
                }else if(sign == '*'){
                    st.push(st.pop() * num);
                }else{
                    st.push(st.pop() / num);
                }
                sign = ch;
                num = 0;
            }
        }

        while(!st.isEmpty()){
            val += st.pop();
        }
        return val;
    }

    // Time : O(n) // as we scan each element
    // Space : O(n) // as we store elements in stack
}