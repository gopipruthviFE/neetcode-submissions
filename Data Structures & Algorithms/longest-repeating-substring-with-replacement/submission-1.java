class Solution {
    public int characterReplacement(String s, int k) {
        int left = 0;
        int[] freq = new int[128];
        int maxLength = 0;
        int maxFreq = 0;

        for(int i=0;i<s.length();i++){
            freq[s.charAt(i)]++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(i)]);

            while(left < i && (i - left + 1 - maxFreq) > k){
                freq[s.charAt(left)]--;
                left++;
            }

            maxLength = Math.max(maxLength, i - left + 1);
        }

        return maxLength;
    }

    // Time : O(n) <--> as we scan each element atmost once
    // Space : O(1)  <--> we only took constant array
}
