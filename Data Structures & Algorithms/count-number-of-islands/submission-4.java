class Solution {
    int[][] dirs = new int[][]{{1, 0},{0, 1},{-1, 0}, {0, -1}};
    public void dfs(int row, int col, int rows, int cols, char[][] grid){
        if(row < 0 || col < 0 || row > rows || col > cols){
            return;
        }

        if(grid[row][col] == '0'){
            return;
        }

        grid[row][col] = '0';

        for(int[] dir : dirs){
            int nRow = dir[0];
            int nCol = dir[1];
            dfs(row + nRow, col + nCol, rows, cols, grid);
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int count = 0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == '1'){
                    count++;
                    dfs(i, j, m - 1, n - 1, grid);
                }
            }
        }

        return count;
    }

    //Time : O(m * n)
    //Space : O(m * n)
}
