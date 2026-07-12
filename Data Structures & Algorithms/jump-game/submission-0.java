class Solution {
    public boolean canJump(int[] nums) {
        int farthestIndex = 0;
        
        for(int i=0;i<nums.length;i++){
            if(i > farthestIndex){
                return false;
            }
            farthestIndex = Math.max(farthestIndex, i + nums[i]);
        }

        return true;
    }
}
