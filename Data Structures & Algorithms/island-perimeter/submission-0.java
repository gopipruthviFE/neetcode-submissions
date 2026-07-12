class Solution {

    /*
     * Problem: Island Perimeter
     *
     * grid[i][j] = 1 means land.
     * grid[i][j] = 0 means water.
     *
     * We are given exactly one island.
     * Cells are connected only in 4 directions:
     * up, down, left, right.
     *
     * Goal:
     * Return the perimeter of the island.
     *
     *
     * Core Idea:
     *
     * For every land cell, check its 4 sides.
     *
     * A side contributes 1 to perimeter if:
     *
     * 1. The neighbor is outside the grid.
     *    Example: land cell at border.
     *
     * OR
     *
     * 2. The neighbor is water.
     *
     *
     * We use DFS to visit all connected land cells once.
     */

    int totalPerimeter = 0;

    /*
     * Four directions:
     * right, down, left, up
     */
    int[][] dirs = {
        {0, 1},
        {1, 0},
        {0, -1},
        {-1, 0}
    };

    /*
     * dfs(row, col)
     *
     * Visits one land cell and explores all connected land cells.
     *
     * Time Complexity:
     * O(rows * cols)
     *
     * Explanation:
     * - In the worst case, the whole grid is land.
     * - Each cell is visited at most once.
     * - For each land cell, we check 4 directions.
     * - So total time is O(rows * cols).
     *
     * Space Complexity:
     * O(rows * cols)
     *
     * Explanation:
     * - visited array takes O(rows * cols).
     * - DFS recursion stack can also go up to O(rows * cols)
     *   in the worst case.
     */
    public void dfs(
        int row,
        int col,
        int rows,
        int cols,
        int[][] grid,
        boolean[][] visited
    ) {

        /*
         * If current cell is outside the grid, stop.
         *
         * We do not count perimeter here because perimeter is counted
         * while checking neighbors of a valid land cell.
         */
        if (row < 0 || row >= rows || col < 0 || col >= cols) {
            return;
        }

        /*
         * If current cell is water, stop.
         */
        if (grid[row][col] == 0) {
            return;
        }

        /*
         * If already visited, stop.
         */
        if (visited[row][col]) {
            return;
        }

        /*
         * Mark this land cell as visited.
         */
        visited[row][col] = true;

        /*
         * Check all 4 sides of current land cell.
         */
        for (int[] dir : dirs) {

            int nRow = row + dir[0];
            int nCol = col + dir[1];

            /*
             * Case 1:
             * Neighbor is outside the grid.
             *
             * This side contributes to perimeter.
             */
            if (nRow < 0 || nRow >= rows || nCol < 0 || nCol >= cols) {
                totalPerimeter++;
            }

            /*
             * Case 2:
             * Neighbor is inside the grid but is water.
             *
             * This side also contributes to perimeter.
             */
            else if (grid[nRow][nCol] == 0) {
                totalPerimeter++;
            }

            /*
             * Case 3:
             * Neighbor is unvisited land.
             *
             * Continue DFS.
             */
            else if (!visited[nRow][nCol]) {
                dfs(nRow, nCol, rows, cols, grid, visited);
            }
        }
    }

    /*
     * islandPerimeter(grid)
     *
     * Time Complexity:
     * O(rows * cols)
     *
     * Explanation:
     * - We may scan the grid to find the first land cell.
     * - DFS visits each land cell once.
     * - Total time is O(rows * cols).
     *
     * Space Complexity:
     * O(rows * cols)
     *
     * Explanation:
     * - visited array takes O(rows * cols).
     * - recursion stack can take O(rows * cols) in worst case.
     */
    public int islandPerimeter(int[][] grid) {

        int rows = grid.length;
        int cols = grid[0].length;

        boolean[][] visited = new boolean[rows][cols];

        /*
         * Find the first land cell.
         *
         * Since there is exactly one island,
         * one DFS from the first land cell is enough.
         */
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {

                if (grid[row][col] == 1) {
                    dfs(row, col, rows, cols, grid, visited);

                    /*
                     * Return immediately because there is only one island.
                     */
                    return totalPerimeter;
                }
            }
        }

        return totalPerimeter;
    }
}