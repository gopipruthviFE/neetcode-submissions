class Solution {
    public int reverseBits(int n) {
        int low = 0;
        int high = 31;

        while(low < high){
           int lowBit = (n >> low) & 1;
           int highBit = (n >> high) & 1;
           if(lowBit != highBit){// xor toggles
                n ^= (1 << low);
                n ^= (1 << high); 
           }
           high--;
           low++;
        }

        return n;
    }
}
