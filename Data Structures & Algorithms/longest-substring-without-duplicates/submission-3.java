class Solution {
    public int lengthOfLongestSubstring(String s) {
        int left = 0;
        Set<Character> set = new HashSet<>();
        int maxLength = 0;

        for(int right = 0;right<s.length();right++){
            while(!set.isEmpty() && set.contains(s.charAt(right))){
                set.remove(s.charAt(left));
                left++;
            }
            set.add(s.charAt(right));
            maxLength = Math.max(maxLength, right - left + 1);
        }

        return maxLength;
    }
    // Time : O(n) <--> as we iterate over each element and set lookup is O(1) only
    // Space : O(n) <--> as we have took hashset which stores n elements in the worst case whem all elements are unique
}
