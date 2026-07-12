class Solution {
    public int hammingWeight(int n) {
        int count = 0;

        while(n != 0){
            n = n & (n - 1);// removes the lowest set Bit so when n = 0 all bits are 0
            count++;
        }

        return count;
    }
}
