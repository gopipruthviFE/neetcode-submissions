class Solution {
    public void islandsAndTreasure(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> que = new LinkedList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 0){
                    que.offer(new int[]{i, j});
                }
            }
        }

        int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};

        while(!que.isEmpty()){
            int size = que.size();

            for(int i=0;i<size;i++){
                int[] top = que.poll();
                int row = top[0];
                int col = top[1];

                for(int[] dir : dirs){
                    int nRow = row + dir[0];
                    int nCol = col + dir[1];

                    if(nRow >= 0 && nRow < m && nCol >=0 && nCol < n && grid[nRow][nCol] != -1 && grid[nRow][nCol] == Integer.MAX_VALUE){
                        grid[nRow][nCol] = grid[row][col] + 1;
                        que.offer(new int[]{nRow,nCol});
                    }
                }
            }
        }
    }
    // Time : O(m * n)
    // Space : O(m * n)
}
