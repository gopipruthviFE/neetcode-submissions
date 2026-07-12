class Solution {
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public void dfs(int row, int col, int rows, int cols, char[][] board){
        if(row < 0 || row > rows || col < 0 || col > cols){
            return;
        }

        if(board[row][col] == 'X' || board[row][col] == 'S'){
            return;
        }
        board[row][col] = 'S';

        for(int[] dir : dirs){
            int nRow = row + dir[0];
            int nCol = col + dir[1];

            dfs(nRow, nCol, rows, cols, board);
        }
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i == 0 || j == 0 || i == m - 1 || j == n - 1){
                    dfs(i, j, m - 1, n - 1, board);
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == 'O'){
                    board[i][j] = 'X';
                }else if(board[i][j] == 'S'){
                    board[i][j] = 'O';
                }
            }
        }
    }

    // Time : O(m * n)
    // Space : O(m * n)
}
