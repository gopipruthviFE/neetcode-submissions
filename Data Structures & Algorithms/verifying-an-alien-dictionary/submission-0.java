class Solution {
    public boolean isAlienSorted(String[] words, String order) {
        int n = words.length;
        int[] rank = new int[26];
        int m = order.length();

        for(int i=0;i<m;i++){
            char ch = order.charAt(i);
            rank[ch - 'a'] = i;
        }

        for(int i=1;i<n;i++){
            String word1 = words[i - 1];
            String word2 = words[i];

            if(!isInCorrectOrder(word1, word2, rank)){
                return false;
            }
        }

        return true;
    }

    public boolean isInCorrectOrder(String word1, String word2, int[] rank){
        int len1 = word1.length();
        int len2 = word2.length();

        int minLen = Math.min(len1, len2);

        for(int i=0;i<minLen;i++){
            char ch1 = word1.charAt(i);
            char ch2 = word2.charAt(i);

            if(ch1 == ch2){
                continue;
            }

            return rank[ch1 - 'a'] < rank[ch2 - 'a'];
        }

        return len1 <= len2;
    }
}