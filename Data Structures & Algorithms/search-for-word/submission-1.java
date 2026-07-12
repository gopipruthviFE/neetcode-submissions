class Solution {
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public boolean dfs(int row, int col, int rows, int cols, String word, char[][] board, int idx){
        if(row < 0 || row > rows || col < 0 || col > cols || idx > word.length()){
            return false;
        }

        if(board[row][col] == '0'){
            return false;
        }

        if(idx == word.length()){
            return true;
        }
        char temp = board[row][col];

        board[row][col] = '0';

        for(int[] dir : dirs){
            int nRow = row + dir[0];
            int nCol = col + dir[1];

            if(nRow >= 0 && nRow <= rows && nCol >= 0 && nCol <= cols && idx < word.length() && board[nRow][nCol] != '0' && board[nRow][nCol] == word.charAt(idx)){
                if(dfs(nRow, nCol, rows, cols, word, board, idx + 1)){
                    return true;
                }
            }
        }
        board[row][col] = temp;
        return false;
    }
    public boolean exist(char[][] board, String word) {
        int m = board.length;
        int n = board[0].length;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == word.charAt(0)){
                    if(dfs(i, j, m - 1, n - 1, word, board, 1)){
                        return true;
                    }
                }
            }
        }
        return false;
    }

    // Time : O(m * n)
    // Space : O(m * n)
}
