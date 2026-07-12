class Solution {
    public String minWindow(String s, String t) {
        int m = s.length();
        int n = t.length();

        if(m < n){
            return "";
        }
        int[] freqS = new int[256];
        int[] freqT = new int[256];
        int required = 0;
        int formed = 0;
        int left = 0;
        int minStart = 0;
        int minLength = Integer.MAX_VALUE;

        for(int i=0;i<n;i++){
            if(freqT[t.charAt(i)] == 0){
                required++;
            }
            freqT[t.charAt(i)]++;
        }

        for(int i=0;i<m;i++){
            freqS[s.charAt(i)]++;
            if(freqS[s.charAt(i)] == freqT[s.charAt(i)]){
                formed++;
            }

            while(formed == required){
                freqS[s.charAt(left)]--;
                if(freqS[s.charAt(left)] < freqT[s.charAt(left)]){
                    formed--;
                }
                if(i - left + 1 < minLength){//as curr window is valid
                    minStart = left;
                    minLength = i - left + 1;
                }
                left++;
            }
        }

        return minLength != Integer.MAX_VALUE ? s.substring(minStart, minStart + minLength) : "";
    }
}
