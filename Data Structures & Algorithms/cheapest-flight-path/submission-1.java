class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;
        Queue<int[]> que = new LinkedList<>();
        List<List<int[]>> adj = new ArrayList<>();

        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }

        for(int[] flight : flights){
            adj.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        que.offer(new int[]{src, 0});
        int count = 0;

        while(!que.isEmpty() && count <= k){
            int size = que.size();

            for(int i=0;i<size;i++){
                int[] node = que.poll();
                int u = node[0];
                int d = node[1];

                for(int[] nbr : adj.get(u)){
                    int v = nbr[0];
                    int w = nbr[1];
                    
                    if(d + w < dist[v]){
                        dist[v] = d + w;
                        que.offer(new int[]{v, dist[v]});
                    }
                }
            }
            count++;
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];        
    }

    // Time : 

    // Time : O(k * E)
    // Space : O(n)
}
