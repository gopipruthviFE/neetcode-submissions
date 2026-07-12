class Solution {
    public List<String> buildQueens(int[] queenCol, int n){
        List<String> board = new ArrayList<>();
        for(int i=0;i<n;i++){
            char[] chars = new char[n];
            Arrays.fill(chars,'.');
            chars[queenCol[i]] = 'Q';
            board.add(new String(chars));
        }
        return board;
    }
    public void backtrack(int start, int n, Set<Integer> cols, Set<Integer> diag, Set<Integer> antidiag,int[] queenCol, List<List<String>> res){
        if(start == n){
            res.add(buildQueens(queenCol, n));
            return;
        }

        for(int j=0;j<n;j++){
            if(cols.contains(j) || diag.contains(start + j) || antidiag.contains(start - j)){
                continue;
            }
            cols.add(j);
            diag.add(start + j);
            antidiag.add(start - j);
            queenCol[start] = j;
            backtrack(start + 1, n, cols, diag, antidiag, queenCol, res);
            cols.remove(j);
            diag.remove(start + j);
            antidiag.remove(start - j);
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> res = new ArrayList<>();
        Set<Integer> cols = new HashSet<>();
        Set<Integer> diag = new HashSet<>();
        Set<Integer> antidiag = new HashSet<>();
        int[] queenCol = new int[n];
        backtrack(0, n, cols, diag, antidiag, queenCol, res);
        return res;
    }

    // Time : O(n! * n)
    // Space : O(n ^ 2)
}
