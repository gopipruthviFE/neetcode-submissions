class Solution {
    public int[] getOrder(int[][] tasks) {
        int n = tasks.length;

        int[][] sorted = new int[n][3];

        for(int i=0;i<n;i++){
            sorted[i][0] = tasks[i][0];
            sorted[i][1] = tasks[i][1];
            sorted[i][2] = i;
        }

        Arrays.sort(sorted, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] == b[1] ? Integer.compare(a[2], b[2]) : Integer.compare(a[1], b[1]));

        int time = 0;
        int taskIdx = 0;
        int[] res = new int[n];
        int resIdx = 0;

        while(resIdx < n){
            while(taskIdx < n && sorted[taskIdx][0] <= time){
                pq.offer(sorted[taskIdx]);
                taskIdx++;
            }

            if(pq.isEmpty()){
                time = sorted[taskIdx][0];
            }else{
                int[] task = pq.poll();
                res[resIdx] = task[2];
                resIdx++;
                time += task[1];
            }
        }

        return res;
    }
}