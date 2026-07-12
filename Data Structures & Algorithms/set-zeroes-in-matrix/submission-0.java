class Solution {
    public void setZeroes(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        boolean isFirstRowEffected = false;
        boolean isFirstColEffected = false;

        for(int j=0;j<n;j++){
            if(matrix[0][j] == 0){
                isFirstRowEffected = true;
                break;
            }
        }

        for(int i=0;i<m;i++){
            if(matrix[i][0] == 0){
                isFirstColEffected = true;
                break;
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(matrix[i][j] == 0){
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }

        for(int i=1;i<m;i++){//as for 1st row and 1st column we have marked in earlier loop start from next element
            for(int j=1;j<n;j++){
                if(matrix[i][0] == 0 || matrix[0][j] == 0){
                    matrix[i][j] = 0;
                }
            }
        }

        if(isFirstRowEffected){
            for(int j=0;j<n;j++){
                matrix[0][j] = 0;
            }
        }

        if(isFirstColEffected){
            for(int i=0;i<m;i++){
                matrix[i][0] = 0;
            }
        }
    }

    // Time : O(m * n) <--> as we check each and every element
    // Space : O(1) <--> no additional space is used only constant varialbles
}
