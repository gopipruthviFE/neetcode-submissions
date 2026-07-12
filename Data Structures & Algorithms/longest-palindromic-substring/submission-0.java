class Solution {
    public int expand(String s, int low, int high){
        while(low >=0 && high <= s.length() - 1 && s.charAt(low) == s.charAt(high)){
            low--;
            high++;
        }

        return (high - 1) - (low + 1) + 1;
    }
    public String longestPalindrome(String s) {
        int n = s.length();
        int maxLength = 0;
        int startIndex = 0;

        for(int i=0;i<n;i++){
            int len1 = expand(s, i, i);
            int len2 = expand(s, i, i + 1);

            if(len1 > maxLength){
                maxLength = len1;
                startIndex = i - (len1 / 2);
            }

            if(len2 > maxLength){
                maxLength = len2;
                startIndex = i - (len2 / 2) + 1;
            }
        }

        return s.substring(startIndex, startIndex + maxLength);
    }

    // Time : O(n ^ 2) <--> as we iterate for calling expand function and expand takes O(n) in worst case when entire string is a palindrome
    // Space : O(1) <--> as we dont have recursion stack or dp array
}
