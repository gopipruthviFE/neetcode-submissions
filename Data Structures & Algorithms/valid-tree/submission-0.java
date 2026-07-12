class Solution {
    int[] parent;
    int[] size;

    public int find(int x){
        while(parent[x] != x){
            parent[x] = parent[parent[x]];
            x = parent[x];
        }
        return x;
    }
    public boolean union(int a, int b){
        int ra = find(a);
        int rb = find(b);

        if(ra == rb){
            return false;
        }

        if(size[ra] < size[rb]){
            int temp = ra;
            ra = rb;
            rb = temp;
        }

        parent[rb] = ra;
        size[ra] += size[rb];

        return true;
    }
    public boolean validTree(int n, int[][] edges) {
        if(edges.length != n - 1){
            return false;
        }
        parent = new int[n];
        size = new int[n];

        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }
        for(int[] edge : edges){
            if(!union(edge[0], edge[1])){
                return false;
            }
        }

        return true;
    }
    // Time : O(n + E * k(n))
    // Space : O(n)
}
