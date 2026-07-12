class Solution {
    public boolean isValidSudoku(char[][] board) {
        List<Set<Character>> rows = new ArrayList<>();
        List<Set<Character>> cols = new ArrayList<>();
        List<Set<Character>> subBox = new ArrayList<>();

        int m = board.length;
        int n = board[0].length;

        for(int i=0;i<m;i++){
            rows.add(new HashSet<>());
            cols.add(new HashSet<>());
            subBox.add(new HashSet<>());
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j] == '.'){
                    continue;
                }

                if(rows.get(i).contains(board[i][j])){
                    return false;
                }else if(cols.get(j).contains(board[i][j])){
                    return false;
                }else if(subBox.get((i/3) * 3 + j/3).contains(board[i][j])){
                    return false;
                }else{
                    rows.get(i).add(board[i][j]);
                    cols.get(j).add(board[i][j]);
                    subBox.get((i/3) * 3 + j/3).add(board[i][j]);
                }
            }
        }

        return true;
    }
}
