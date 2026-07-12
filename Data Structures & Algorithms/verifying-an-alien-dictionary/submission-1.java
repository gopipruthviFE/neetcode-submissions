class Solution {

    /*
     * Problem: Verifying an Alien Dictionary
     *
     * Given:
     * - words[]: list of words written in alien language
     * - order: custom alphabet order
     *
     * Goal:
     * Return true if words are sorted lexicographically
     * according to alien order.
     *
     *
     * Pattern:
     * Custom lexicographical comparison.
     *
     *
     * Not DSU:
     * - DSU groups connected components.
     * - This problem does not merge anything.
     * - We only compare adjacent words using custom character ranks.
     *
     *
     * Time Complexity:
     * O(C)
     *
     * Explanation:
     * - C = total number of characters compared across adjacent word pairs.
     * - Building rank array takes O(26), which is constant.
     * - In worst case, adjacent comparisons may scan characters.
     * - Overall commonly written as O(total characters in words).
     *
     *
     * Space Complexity:
     * O(1)
     *
     * Explanation:
     * - rank array has size 26.
     * - 26 is constant.
     */
    public boolean isAlienSorted(String[] words, String order) {

        /*
         * rank[ch - 'a'] stores the position of character ch
         * in the alien alphabet.
         *
         * Smaller rank means character comes earlier.
         */
        int[] rank = new int[26];

        /*
         * Build character rank map from alien order.
         */
        for (int i = 0; i < order.length(); i++) {
            char ch = order.charAt(i);
            rank[ch - 'a'] = i;
        }

        /*
         * Check every adjacent pair.
         *
         * If every words[i] <= words[i + 1],
         * then the whole list is sorted.
         */
        for (int i = 0; i < words.length - 1; i++) {
            if (!isInCorrectOrder(words[i], words[i + 1], rank)) {
                return false;
            }
        }

        return true;
    }

    /*
     * Returns true if word1 comes before or equal to word2
     * according to alien dictionary order.
     */
    private boolean isInCorrectOrder(String word1, String word2, int[] rank) {

        int len1 = word1.length();
        int len2 = word2.length();

        /*
         * Compare characters until one word ends.
         */
        int minLen = Math.min(len1, len2);

        for (int i = 0; i < minLen; i++) {

            char c1 = word1.charAt(i);
            char c2 = word2.charAt(i);

            /*
             * If characters are same, continue checking next character.
             */
            if (c1 == c2) {
                continue;
            }

            /*
             * First different character decides the order.
             */
            return rank[c1 - 'a'] < rank[c2 - 'a'];
        }

        /*
         * If all compared characters are same,
         * then shorter word should come first.
         *
         * Valid:
         * "app" before "apple"
         *
         * Invalid:
         * "apple" before "app"
         */
        return len1 <= len2;
    }
}