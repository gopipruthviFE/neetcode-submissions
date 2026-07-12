class Solution {
    // public int lcs(int i, int j, int m, int n,String text1,String text2){
    //     if(i >= m || j >= n){
    //         return 0;
    //     }

    //     if(text1.charAt(i) == text2.charAt(j)){
    //         return 1 + lcs(i + 1, j + 1, m, n, text1, text2);
    //     }

    //     return Math.max(lcs(i, j + 1, m, n, text1, text2), lcs(i + 1, j, m, n, text1, text2));
    // }
    // public int longestCommonSubsequence(String text1, String text2) {
    //     return lcs(0, 0, text1.length(),text2.length(), text1, text2);
    // }

    // Time : O(2 ^ (m + n)) <--> as at each place we have 2 choices of skpping from 1st string and skipping from 2nd string
    // Space : O(m + n) <--> call f(i, j + 1) again and again till j == n abnd then we again call f(i + 1, j + 1) so on again till i reaches m

    // public int lcs(int i, int j, int m, int n,String text1,String text2, int[][] dp){
    //     if(i >= m || j >= n){
    //         return 0;
    //     }

    //     if(dp[i][j] != -1){
    //         return dp[i][j];
    //     }

    //     if(text1.charAt(i) == text2.charAt(j)){
    //         return dp[i][j] = 1 + lcs(i + 1, j + 1, m, n, text1, text2, dp);
    //     }

    //     return dp[i][j] = Math.max(lcs(i, j + 1, m, n, text1, text2, dp), lcs(i + 1, j, m, n, text1, text2, dp));
    // }
    // public int longestCommonSubsequence(String text1, String text2) {
    //     int[][] dp = new int[text1.length()][text2.length()];
    //     //dp[i][j] --> longest common subsequence with i and j length
    //     for(int[] arr : dp){
    //         Arrays.fill(arr, -1);
    //     }
    //     return lcs(0, 0, text1.length(),text2.length(), text1, text2, dp);
    // }

    // Time : O(m * n) <--> as now our choices are computed we only compute each char with other char in string there for m chars in string1 and n chars in string 2 there for m * n
    // Space : O(m * n) <--> for the dp array and O(m + n) recursion depth

    // public int longestCommonSubsequence(String text1, String text2) {
    //     int m = text1.length();
    //     int n = text2.length();
    //     int[][] dp = new int[m + 1][n + 1];
    //     //dp[i][j] --> longest common subsequence with i and j length
    //     for(int[] arr : dp){
    //         Arrays.fill(arr, -1);
    //     }

    //     for(int j=0;j<n+1;j++){
    //         dp[m][j] = 0;
    //     }

    //     for(int i=0;i<m+1;i++){
    //         dp[i][n] = 0;
    //     }

    //     for(int i=m-1;i>=0;i--){
    //         for(int j=n-1;j>=0;j--){
    //             if(text1.charAt(i) == text2.charAt(j)){
    //                 dp[i][j] = 1 + dp[i+1][j+1];
    //             }else{
    //                 dp[i][j] = Math.max(dp[i][j + 1], dp[i + 1][j]);
    //             }
    //         }
    //     }

    //     return dp[0][0];
    // }

    // Time : O(m * n) <--> filling dp array witl all m * n cells
    // Space : O(m * n) <--> for the dp array

    public int longestCommonSubsequence(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[] next = new int[n + 1];

        for(int i=m-1;i>=0;i--){
            int[] curr = new int[n + 1];
            for(int j=n-1;j>=0;j--){
                if(text1.charAt(i) == text2.charAt(j)){
                    curr[j] = 1 + next[j+1];
                }else{
                    curr[j] = Math.max(curr[j + 1], next[j]);
                }
            }
            next = curr;
        }

        return next[0];
    }

    // Time : O(m * n) <--> as we iterate each and every char which forms m * n chars
    // Space : O(n) <--> as we create curr array
}
