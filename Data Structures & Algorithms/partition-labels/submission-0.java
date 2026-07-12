class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        int[] lastOcc = new int[26];

        for(int i=0;i<n;i++){
            lastOcc[s.charAt(i) - 'a'] = i;
        }

        int i=0;
        List<Integer> res = new ArrayList<>();

        while(i < n){
            int end = lastOcc[s.charAt(i) - 'a'];
            int j = i;

            while(j < end){
                end = Math.max(lastOcc[s.charAt(j) - 'a'], end);
                j++;
            }
            res.add(j - i + 1);
            i = j + 1;
        }

        return res;
    }
}
