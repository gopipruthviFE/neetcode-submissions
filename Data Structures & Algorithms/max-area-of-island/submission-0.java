class Solution {
    int[][] dirs = new int[][]{{0,  1}, {1, 0}, {-1, 0}, {0, -1}};
    public int dfs(int row, int col, int rows, int cols, int[][] grid){
        if(row < 0 || row > rows || col < 0 || col > cols){
            return 0;
        }

        if(grid[row][col] == 0){
            return 0;
        }

        grid[row][col] = 0;
        int count = 1;

        for(int[] dir : dirs){
            count += dfs(row + dir[0], col + dir[1], rows, cols, grid);
        }

        return count;
    }
    public int maxAreaOfIsland(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        int maxCount = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 1){
                    int count = dfs(i, j, m - 1, n - 1, grid);
                    maxCount = Math.max(count, maxCount);
                }
            }
        }

        return maxCount;
    }

    // Time : O(m * n)
    // Space : O(m * n)
}
