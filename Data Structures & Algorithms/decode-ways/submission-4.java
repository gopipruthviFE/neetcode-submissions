class Solution {
    public int decodeWays(int i, String s, int[] dp){
        if(i == -1){
            return 1;
        }
        if(i == 0){
            return dp[i] = Integer.parseInt(s.substring(i, i + 1)) == 0 ? 0 : 1;
        }
        if(dp[i] != -1){
            return dp[i];
        }

        int ways = 0;
        if(i - 1 >= 0){
            int x = Integer.parseInt(s.substring(i - 1, i + 1));
            if(x >= 10 && x <= 26){
                ways = decodeWays(i - 2, s, dp);
            }
        }

        int y = Integer.parseInt(s.substring(i, i + 1));
        if(y != 0){
            ways += decodeWays(i - 1, s, dp);
        }
        return dp[i] = ways;
    }
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        decodeWays(n - 1, s, dp);
        return dp[n - 1];
    }

    // Time : O(n * 2)
    // Space : O(n)
}
