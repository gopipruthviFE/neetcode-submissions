class Solution {
    public boolean breakWord(int start, int end, String s, Set<String> words, Boolean[] dp){
        if(start < 0){
            return true;
        }
        if(dp[start] != null){
            return dp[start];
        }
        for(int i=start;i>=0;i--){
            String word = s.substring(i, end);
            if(words.contains(word) && breakWord(i - 1, i, s, words, dp)){
                return dp[start] = true;
            } 
        }

        return dp[start] = false;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        Set<String> words = new HashSet<>(wordDict);
        Boolean[] dp = new Boolean[n];

        breakWord(n - 1, n, s, words, dp);
        return dp[n - 1];
    }

    // Time : O(n * n)
    // Space : O(n)
}
