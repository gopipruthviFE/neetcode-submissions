class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        int n = strs.length;
        Map<String, List<String>> map = new HashMap<>();

        for(int i=0;i<n;i++){
            int size = strs[i].length();
            int[] freq = new int[26];

            for(int j=0;j<size;j++){
                freq[strs[i].charAt(j) - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for(int k=0;k<26;k++){
                sb.append(freq[k]);
                sb.append('#');
            }
            map.computeIfAbsent(sb.toString(), k -> new ArrayList<>()).add(strs[i]);
        }

        return new ArrayList<>(map.values());
    }
}
