class Solution {
    public boolean matches(int[] freqS1, int[] freqS2){
        for(int i=0;i<26;i++){
            if(freqS1[i] != freqS2[i]){
                return false;
            }
        }

        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();

        if(m > n){
            return false;
        }

        int[] freqS1 = new int[26];
        int[] freqS2 = new int[26];
        int formed = 0;
        int left = 0;

        for(int i=0;i<m;i++){
            freqS1[s1.charAt(i) - 'a']++;
            freqS2[s2.charAt(i) - 'a']++;
        }

        if(matches(freqS1, freqS2)){
            return true;
        }

        for(int i=m;i<n;i++){
            freqS2[s2.charAt(i) - 'a']++;
            freqS2[s2.charAt(left) - 'a']--;
            left++;
            
            if(matches(freqS1, freqS2)){
                return true;
            }
        }

        return false;
    }
}
