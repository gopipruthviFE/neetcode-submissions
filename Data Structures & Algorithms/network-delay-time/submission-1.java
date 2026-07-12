class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<int[]>> adj = new ArrayList<>();
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[1], b[1]));
        int[] dist = new int[n + 1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k] = 0;
        pq.offer(new int[] {k, 0});

        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] time : times){
            int u = time[0];
            int v = time[1];
            int w = time[2];
            adj.get(u).add(new int[] {v, w});
        }

        while(!pq.isEmpty()){
            int size = pq.size();

                int[] node = pq.poll();
                int u = node[0];
                int d = node[1];

                if(d > dist[u]){
                    continue;
                }

                for(int[] edge : adj.get(u)){
                    int v = edge[0];
                    int w = edge[1];
                    if( d + w < dist[v]){
                        dist[v] = d + w;
                        pq.offer(new int[] {v, dist[v]});
                    }
                }
        }

        int ans = 0;
        for(int i=1;i<=n;i++){
            if(dist[i] == Integer.MAX_VALUE){
                return -1;
            }
            ans = Math.max(ans, dist[i]);
        }

        return ans;
    }

    // Time : O(V) + O(VLogV * E)
    // Space : O(VlogV) + V * V
}
