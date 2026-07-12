class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        Queue<int[]> que = new LinkedList<>();
        int fresh = 0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j] == 2){
                    que.offer(new int[]{i, j});
                }else if(grid[i][j] == 1){
                    fresh++;
                }
            }
        }

        int[][] dirs = new int[][]{{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
        int time = 0;

        while(!que.isEmpty() && fresh > 0){
            int size = que.size();
            time++;
            for(int i=0;i<size;i++){
                int[] top = que.poll();
                int row = top[0];
                int col = top[1];
                
                for(int[] dir : dirs){
                    int nRow = row + dir[0];
                    int nCol = col + dir[1];

                    if(nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && grid[nRow][nCol] == 1){
                        fresh--;
                        grid[nRow][nCol] = 2;
                        que.offer(new int[]{nRow, nCol});
                    }
                }
            }
        }

        return fresh == 0 ? time : -1;
    }
}
