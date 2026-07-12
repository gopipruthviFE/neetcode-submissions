class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        for(int i=0;i<=k;i++){
            int[] prev = dist.clone();

            for(int[] flight : flights){
                int u = flight[0];
                int v = flight[1];
                int w = flight[2];

                if(prev[u] == Integer.MAX_VALUE){
                    continue;
                }

                if(prev[u] + w < dist[v]){
                    dist[v] = prev[u] + w;
                }
            }
        }

        return dist[dst] == Integer.MAX_VALUE ? -1 : dist[dst];
    }

    // Time : O(k * E)
    // Space : O(n)
}
