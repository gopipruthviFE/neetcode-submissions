class Solution {
    public void expand(String s, int low, int high, List<String> list){
        while(low >=0 && high < s.length() && s.charAt(low) == s.charAt(high)){
            high++;
            list.add(s.substring(low, high));
            low--;
        }
    }
    public int countSubstrings(String s) {
        int n = s.length();
        List<String> list = new ArrayList<>();

        for(int i=0;i<n;i++){
            expand(s, i, i, list);
            expand(s, i, i + 1, list);
        }

        return list.size();
    }
}
