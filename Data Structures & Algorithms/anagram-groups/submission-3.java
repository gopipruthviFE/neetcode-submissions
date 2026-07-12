class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> group = new HashMap<>();

        for(int i=0;i<strs.length;i++){
            int[] freq = new int[26];
            StringBuilder sb = new StringBuilder();

            String word = strs[i];
            for(int j=0;j<word.length();j++){
                freq[word.charAt(j) - 'a']++;
            }

            for(int k=0;k<26;k++){
                sb.append(freq[k]);
                sb.append('#');
            }

            group.computeIfAbsent(sb.toString(), k -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(group.values());
    }

    // Time : O(n * L) <--> as we iterate each word once and we iterate an average Length of L for each string
    // Space : O(n * L) <--> as we store n strings each of an average length L
}
