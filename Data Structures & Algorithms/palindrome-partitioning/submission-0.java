class Solution {
    public boolean isPalindrome(String s){
        int low = 0;
        int high = s.length() - 1;

        while(low < high){
            if(s.charAt(low) != s.charAt(high)){
                return false;
            }
            low++;
            high--;
        }
        return true;
    }
    public void backtrack(int start, int n, String s, List<List<String>> res, List<String> list){
        if(start == n){
            res.add(new ArrayList<>(list));
            return;
        }

        for(int i=start+1;i<=n;i++){
            String sub = s.substring(start, i);
            if(isPalindrome(sub)){
                list.add(sub);
                backtrack(i, n, s, res, list);
                list.remove(list.size() - 1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        int n = s.length();
        List<List<String>> res = new ArrayList<>();
        backtrack(0, n, s, res, new ArrayList<>());
        return res;
    }

    // Time : O(2 ^ n)
    // Space : O(n)
}
