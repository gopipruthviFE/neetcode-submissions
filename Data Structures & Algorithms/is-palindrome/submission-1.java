class Solution {
    public boolean isPalindrome(String s) {
        int n = s.length();

        int low = 0;
        int high = n - 1;

        while(low < high){
            while(low < high && !Character.isLetterOrDigit(s.charAt(low))){
                low++;
            }
            while(low < high && !Character.isLetterOrDigit(s.charAt(high))){
                high--;
            }

            if(Character.toLowerCase(s.charAt(low)) != Character.toLowerCase(s.charAt(high))){
                return false;
            }
            low++;
            high--;
        }

        return true;
    }
    // Time : O(n) <--> as we check each character only one time
    // Space : O(1) <--> no extra space is used here
}
