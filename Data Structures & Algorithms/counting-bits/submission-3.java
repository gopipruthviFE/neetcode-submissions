class Solution {
    public int[] countBits(int n) {
        int[] res = new int[n + 1];

        for(int i=0;i<=n;i++){
            int num = i;
            int count = 0;
            for(int j=0;j<32;j++){
                if((num & (1 << j)) != 0){// check if jth bit is set
                    count++;
                }
            }
            res[i] = count;
        }

        return res;
    }
}
