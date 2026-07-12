class Solution {
    public void backtrack(int left, int right, int n, List<String> res, StringBuilder sb){
        if(left == n && right == n){
            res.add(sb.toString());
            return;
        }

        if(left < n){
            sb.append("(");
            backtrack(left + 1, right, n, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if(right < left){
            sb.append(")");
            backtrack(left, right + 1, n, res, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<>();
        backtrack(0, 0, n, res, new StringBuilder());
        return res;
    }
    // Time : O(4 ^ n / sqrt(n))
    // Space : O(n)
}
