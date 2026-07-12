class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        if(grid[0][0] == 1 || grid[m - 1][n - 1] == 1){
            return -1;
        }
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{0, 0});
        int dist = 0;

        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}, {1, 1}, {1, -1}, {1, -1}, {-1, 1}};

        while(!que.isEmpty()){
            int size = que.size();

            for(int i=0;i<size;i++){
                int[] top = que.poll();
                int row = top[0];
                int col = top[1];

                grid[row][col] = -1;
                if(row == m - 1 && col == n - 1){
                    return dist + 1;
                }

                for(int[] dir : dirs){
                    int nRow = row + dir[0];
                    int nCol = col + dir[1];

                    if(nRow >= 0 && nRow < m && nCol >=0 && nCol < n && grid[nRow][nCol] == 0){
                        que.add(new int[]{nRow, nCol});
                    }
                }
            }
            dist++;
        }

        return -1;
    }
}