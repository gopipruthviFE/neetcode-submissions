class Solution {
    int[][] dirs = new int[][]{{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public void dfs(int row, int col, boolean[][] ocean, int[][] heights){
        if(row < 0 || row >= heights.length || col < 0 || col >= heights[0].length){
            return;
        }

        if(ocean[row][col] == true){
            return;
        }

        ocean[row][col] = true;

        for(int[] dir : dirs){
            int nRow = row + dir[0];
            int nCol = col + dir[1];

            if(nRow >=0 && nRow < heights.length && nCol >= 0 && nCol < heights[0].length && heights[nRow][nCol] >= heights[row][col]){
                dfs(nRow, nCol, ocean, heights);
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];
        List<List<Integer>> list = new ArrayList<>();

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i == 0 || j == 0){
                    dfs(i, j, pacific, heights);
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i == m - 1 || j == n - 1){
                    dfs(i, j, atlantic, heights);
                }
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific[i][j] == true && atlantic[i][j] == true){
                    list.add(Arrays.asList(i, j));
                }
            }
        }

        return list;
    }

    // Time : O(m * n)
    // Space : O(m * n)
}
