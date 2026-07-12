class Solution {
    public int singleNumber(int[] nums) {
        int xor = nums[0];
        for(int i=1;i<nums.length;i++){
            xor = xor ^ nums[i];//1 ^ a = a; a ^ a = 1;
        }

        return xor;
    }
}
