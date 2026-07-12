class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;

        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);// imp
        int prefixSum = 0;
        int count = 0;

        for(int i=0;i<n;i++){
            prefixSum += nums[i];
            int curr = prefixSum - k;

            if(map.containsKey(prefixSum - k)){
                count += map.get(prefixSum - k);
            }

            map.put(prefixSum, map.getOrDefault(prefixSum, 0) + 1);
        }

        return count;
    }
    // Time : O(n) <--> each element is checked only once and map lookUp is O(1)
    // Space : O(n) <--> as we store each element in the map
}