class Solution {
    public int findWays(int m, int n, String s, String t){
        if(m == 0 && n == 0){
            return 1;
        }
        if(n == 0){
            return 1;
        }
        if(m == 0){
            return 0;
        }

        if(s.charAt(m - 1) == t.charAt(n - 1)){
            return findWays(m - 1, n, s, t) + findWays(m - 1, n - 1, s, t);
        }

        return findWays(m - 1, n, s, t);
    }
    public int numDistinct(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[][] dp = new int[m + 1][n + 1];

        for(int[] row : dp){
            Arrays.fill(row, -1);
        }

        return findWays(m , n, s, t);
    }
}
