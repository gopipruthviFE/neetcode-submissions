class Solution {
    public int findWays(int m, int n, String s, String t, int[][] dp){
        if(m == 0 && n == 0){
            return 1;
        }
        if(n == 0){
            return 1;
        }
        if(m == 0){
            return 0;
        }

        if(dp[m][n] != -1){
            return dp[m][n];
        }

        if(s.charAt(m - 1) == t.charAt(n - 1)){
            return dp[m][n] = findWays(m - 1, n, s, t, dp) + findWays(m - 1, n - 1, s, t, dp);
        }

        return dp[m][n] = findWays(m - 1, n, s, t, dp);
    }
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return findWays(m , n, s, t, dp);
    }
}
