class Solution {
    public void reverse(int low, int high,int i, int[][] matrix){
        while(low < high){
            int temp = matrix[i][high];
            matrix[i][high] = matrix[i][low];
            matrix[i][low] = temp;
            low++;
            high--;
        }
    }
    public void rotate(int[][] matrix) {
        // transpose over a diagonal and reverse the rows;

        int m = matrix.length;
        int n = matrix[0].length;

        for(int i=0;i<m;i++){
            for(int j=i+1;j<n;j++){
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        for(int i=0;i<m;i++){
            reverse(0, matrix[i].length - 1, i, matrix);
        }
    }

    // Time : O(m * n) <--> for transpose and reverse
    // Space : O(1) <--> no additional space
}
