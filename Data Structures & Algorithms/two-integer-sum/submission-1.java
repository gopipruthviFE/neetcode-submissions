class Solution {
    public int[] twoSum(int[] nums, int target) {
        // BF : form every pair and check if sum == target
        // optimal : use hashMap for O(1) pair lookup, check if you have seen the compliment earlier

        Map<Integer, Integer> seen = new HashMap<>();

        for(int i=0;i<nums.length;i++){
            int compliment = target - nums[i];
            if(seen.containsKey(compliment)){
                return new int[]{seen.get(compliment), i};
            }
            seen.put(nums[i], i);
        }

        return new int[]{-1, -1};
    }
    // Time : O(n) <--> check each number once and lookUp is O(1) only
    // Space : O(n) <--> as we store atmost n elements in it
}
