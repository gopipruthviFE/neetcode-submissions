class Solution {
    // public int countPaths(int row, int col, int m, int n){// number of ways to reach row and col
    //     if(row >= m || col >=n){// if we cross edges
    //         return 0;
    //     }
    //     // when we reach row=m-1 and col=n-1 then we found a valid path
    //     if(row == m - 1 && col == n - 1){
    //         return 1;
    //     }

    //     return countPaths(row, col + 1, m, n) + countPaths(row + 1, col, m, n);
    // }
    // public int uniquePaths(int m, int n) {
    //     return countPaths(0, 0, m, n);
    // }

    // Time : O(2 ^ n) <--> as each cell has 2 choices to make go right or go down and there are m * n cells
    // Space : O(m + n) <--> in the worst case we visit all the cells and all will be recursion stack of only 1 path

    // public int countPaths(int row, int col, int m, int n, int[][] dp){
    //     if(row >= m || col >=n){
    //         return 0;
    //     }
    //     // when we reach row=m-1 and col=n-1 then we found a valid path
    //     if(row == m - 1 && col == n - 1){
    //         return 1;
    //     }

    //     if(dp[row][col] != -1){
    //         return dp[row][col];
    //     }

    //     return dp[row][col] = countPaths(row, col + 1, m, n, dp) + countPaths(row + 1, col, m, n, dp);
    // }
    // public int uniquePaths(int m, int n) {
    //     int[][] dp = new int[m][n];

    //     for(int[] arr : dp){
    //         Arrays.fill(arr, -1);
    //     }

    //     return countPaths(0, 0, m, n, dp);
    // }

    // Time : O(m * n) <--> as we reach each cell once and and call 2 but this time dp look up is only O(1) now
    // Space : O(m * n) <--> for dp and we make m + n -2 length of path

    // public int uniquePaths(int m, int n) {
    //     int[][] dp = new int[m][n];

    //     for(int j=0;j<n;j++){
    //         dp[0][j] = 1;
    //     }

    //     for(int i=0;i<m;i++){
    //         dp[i][0] = 1;
    //     }

    //     for(int i=1;i<m;i++){
    //         for(int j=1;j<n;j++){
    //             dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
    //         }
    //     }

    //     return dp[m - 1][n - 1];
    // }
    // Time : O(m * n) <--> as we reach each cell once
    // Space : O(m * n) <--> for dp array

    public int uniquePaths(int m, int n) {
        int[] dp = new int[n];

        for(int j=0;j<n;j++){
            dp[j] = 1;
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                dp[j] = dp[j] + dp[j - 1];
            }
        }

        return dp[n - 1];
    }
}
