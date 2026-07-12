class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        int n = nums.length;

        while(slow != n + 1 && fast != n + 1){
            slow = nums[slow];
            fast = nums[nums[fast]];
            if(slow == fast){
                break;
            }
        }
        slow = 0;

        while(slow != fast){
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }
}
