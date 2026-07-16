class Solution {
    public boolean match(int m, int n, String s, String p){
        if(m == 0 && n == 0){
            return true;
        }

        if(m == 0){
            for(int i=n-1;i>=0;i--){
                if(p.charAt(i) != '*' && p.charAt(i) != '.'){
                    return false;
                }
            }
            return true;
        }

        if(n == 0){
            return false;
        }

        if(p.charAt(n - 1) == '.'){
            match(m - 1, n - 1, s, p);
        }

        if(p.charAt(n - 1) == '*'){
            return match(m - 1, n, s, p) || match(m, n - 1, s, p);
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
