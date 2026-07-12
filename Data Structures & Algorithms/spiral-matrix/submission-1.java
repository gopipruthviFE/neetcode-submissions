class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        // as question suggests traverse top, right, bottom, left
        int top = 0;
        int bottom = matrix.length - 1;
        int right = matrix[0].length - 1;
        int left = 0;

        List<Integer> res = new ArrayList<>();

        while(top <= bottom && left <= right){// atleast 1 row and 1 col present to traverse
            for(int j=left;j<=right;j++){
                res.add(matrix[top][j]);
            }
            top++;

            for(int i=top;i<=bottom;i++){
                res.add(matrix[i][right]);
            }
            right--;

            if(top <= bottom){
                for(int j=right;j>=left;j--){
                    res.add(matrix[bottom][j]);
                }
                bottom--;
            }

            if(left <= right){
                for(int i=bottom;i>=top;i--){
                    res.add(matrix[i][left]);
                }
                left++;
            }
        }

        return res;
    }
}
