class Solution {
    public boolean hasDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();

        for(int i=0;i<nums.length;i++){
            if(seen.contains(nums[i])){// If we have already seen the value while iterating then we have a duplicate
                return true;
            }
            seen.add(nums[i]);
        }

        return false;
    }
    // Time : O(n) <--> checking each element only once and lookup in hashset is only O(1)
    // Space : O(n) <--> as we store n elements in the set in the worst case where all elements are unique
}