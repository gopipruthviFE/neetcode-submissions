class Solution {
    public boolean matches(int[] freq1, int[] freq2){
        int n = freq1.length;

        for(int i=0;i<n;i++){
            if(freq1[i] != freq2[i]){
                return false;
            }
        }

        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int left = 0;

        if(m > n){
            return false;
        }

        int[] freq1 = new int[128];
        int[] freq2 = new int[128];

        for(int i=0;i<m;i++){
            freq1[s1.charAt(i)]++;
        }

        for(int j=0;j<m;j++){
            freq2[s2.charAt(j)]++;
        }

        if(matches(freq1, freq2)){
            return true;
        }

        for(int i=m;i<n;i++){
            freq2[s2.charAt(i)]++;
            freq2[s2.charAt(left++)]--;

            if(matches(freq1, freq2)){
                return true;
            }
        }

        return false;
    }

    // Time : O(n * m) <--> as we iterate s2 and check a length of m every time
    // Space : O(1) <--> only constant arrays are used
}
