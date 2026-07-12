class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int writer = 0;
        int count = 1;

        for(int i=1;i<n;i++){
            if(chars[i] == chars[i - 1]){
                count++;
            }else{
                chars[writer++] = chars[i - 1];
                if(count > 1){
                    for(char c : String.valueOf(count).toCharArray()){// for count 12 we need to write it as 'a', '1', '2' --> see example
                        chars[writer++] = c;
                    }
                }
                count = 1;
            }
        }
        chars[writer++] = chars[n - 1];
        if(count > 1){
            for(char c : String.valueOf(count).toCharArray()){// for count 12 we need to write it as 'a', '1', '2' --> see example
                chars[writer++] = c;
            }
            count = 1; 
        }

        return writer;
    }

    // Time : O(n) <--> as we iterate each char and maxlength is just thousands so O(n)
    // Space : O(1) <--> no additional space is used only constant variables
}