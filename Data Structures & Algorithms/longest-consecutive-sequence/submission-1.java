class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        int n = nums.length;
        int maxLength = 0;

        for(int i=0;i<n;i++){
            set.add(nums[i]);
        }

        for(int num : set){
            if(!set.contains(num - 1)){
                int start = num;
                int count = 0;
                while(set.contains(start)){
                    count++;
                    maxLength = Math.max(count, maxLength);
                    start++;
                }
            }
        }

        return maxLength;
    }
}
