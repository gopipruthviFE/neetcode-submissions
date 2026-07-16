class Solution {
    public boolean match(int m, int n, String s, String p){
        if(m == 0 && n == 0){
            return true;
        }

        if(n == 0){
            return false;
        }

        if(p.charAt(n - 1) == '.'){
            return match(m - 1, n - 1, s, p);
        }

        if(p.charAt(n - 1) == '*'){
            boolean zero = match(m, n - 2, s, p);
            boolean nonZero = false;
            if(m > 0 && (p.charAt(n - 2) == s.charAt(m - 1) || p.charAt(n - 2) == '.')){
                nonZero = match(m - 1, n, s, p);
            }

            return zero || nonZero;
        }

        if(p.charAt(n - 1) != s.charAt(m - 1)){
            return false;
        }

        return match(m - 1, n - 1, s, p);
    }
    public boolean isMatch(String s, String p) {
        int m = s.length();
        int n = p.length();

        return match(m, n, s, p);
    }
}
