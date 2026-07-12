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
    public int[] findRedundantConnection(int[][] edges) {
        parent = new int[edges.length + 1];
        size = new int[edges.length + 1];

        for(int i=1;i<edges.length + 1;i++){
            parent[i] = i;
            size[i] = 1;
        }
        for(int[] edge : edges){
            if(!union(edge[0],edge[1])){
                return edge;
            }
        }

        return new int[]{-1, -1};
    }
}
