class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int currGas = 0;

        for(int i=0;i<n;i++){
            if(gas[i] < cost[i]){
                continue;
            }

            int j = (i + 1) % n;
            currGas = gas[i] + gas[j] - cost[i];

            while(j != i){
                if(currGas < cost[j]){
                    break;
                }

                int costSpent = cost[j];

                j = (j + 1) % n;
                currGas = currGas + gas[j] - costSpent;
            }

            if(i == j){
                return i;
            }
        }
        return -1;
    }
}
