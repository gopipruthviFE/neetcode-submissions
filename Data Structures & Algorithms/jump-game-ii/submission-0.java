class Solution {
    public int jump(int[] nums) {
        int farthestIndex = 0;
        int currEnd = 0;
        int minJumps = 0;

        for(int i=0;i<nums.length-1;i++){
            farthestIndex = Math.max(farthestIndex, i + nums[i]);

            if(i == currEnd){
                minJumps++;
                currEnd = farthestIndex;

                if(currEnd >= nums.length - 1){
                    return minJumps;
                }
            }
        }

        return minJumps;
    }
}
