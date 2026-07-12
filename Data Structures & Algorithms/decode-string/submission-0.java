class Solution {
    public String decodeString(String s) {
        int n = s.length();
        Stack<Integer> numStack = new Stack<>();
        Stack<String> stringStack = new Stack<>();
        int num = 0;
        StringBuilder currString = new StringBuilder();

        for(int i=0;i<n;i++){
            char ch = s.charAt(i);

            if(Character.isDigit(ch)){
                num = num * 10 + (ch - '0');
            }else if(ch == '['){
                numStack.push(num);
                stringStack.push(currString.toString());
                currString = new StringBuilder();
                num = 0;
            }else if(ch == ']'){
                int count = numStack.pop();

                StringBuilder build = new StringBuilder();

                for(int j=0;j<count;j++){
                    build.append(currString);
                }
                String prev = stringStack.pop();
                currString = new StringBuilder(prev + build.toString());
            }else{
                currString.append(ch);
            }
        }

        return currString.toString();
    }

    // Time : O(n + k) <--> output length is larger than given string n as we iterate every element and k for building the string
    // Space : O(n + k) <--> as stack stores the nums and string and stringbuilder stores entire outputlength
}