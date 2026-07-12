class Solution {
    public int primsAlgo(List<List<int[]>> adj, int V){
        boolean[] inMST = new boolean[adj.size()];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        int sum = 0;

        pq.offer(new int[]{V, 0});

        while(!pq.isEmpty()){
            int[] minNode = pq.poll();
            int u = minNode[0];
            int d = minNode[1];

            if(inMST[u]){
                continue;
            }

            inMST[u] = true;
            sum += d;

            for(int[] nbr : adj.get(u)){
                int v = nbr[0];
                int w = nbr[1];

                if(!inMST[v]){
                    pq.offer(new int[]{v, w});
                }
            }
        }

        return sum;
    }
    public int minCostConnectPoints(int[][] points) {
        List<List<int[]>> adj = new ArrayList<>();

        for(int i=0;i<points.length;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<points.length;i++){
            for(int j=i+1;j<points.length;j++){
                int dist = Math.abs(points[j][0] - points[i][0]) + Math.abs(points[j][1] - points[i][1]);
                adj.get(i).add(new int[]{j, dist});
                adj.get(j).add(new int[]{i, dist});
            }
        }

        return primsAlgo(adj, 0);
    }

    // Time : O(E * ELogE)
    // Space : O(E)
}
