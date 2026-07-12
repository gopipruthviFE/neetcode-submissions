class Solution {
    public List<Integer> partitionLabels(String s) {
        int n = s.length();
        int[] lastOcc = new int[26];

        for(int i=0;i<n;i++){
            lastOcc[s.charAt(i) - 'a'] = i;
        }

        int i=0;
        int start = 0;
        int end = 0;
        List<Integer> res = new ArrayList<>();

        while(i < n){
            end = Math.max(lastOcc[s.charAt(i) - 'a'], end);

            if(i == end){
                res.add(i - start + 1);
                start = i + 1;
            }
            i++;
        }

        return res;
    }
}
