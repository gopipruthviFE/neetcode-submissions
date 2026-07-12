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

    public void union(int a, int b){
        int ra = find(a);
        int rb = find(b);

        if(size[ra] < size[rb]){
            int temp = ra;
            ra = rb;
            rb = temp;
        }
        parent[rb] = ra;
        size[ra] += size[rb];
    }
    public int countComponents(int n, int[][] edges) {
        parent = new int[n];
        size = new int[n];

        for(int i=0;i<n;i++){
            parent[i] = i;
            size[i] = 1;
        }

        for(int[] edge : edges){
            union(edge[0], edge[1]);
        }

        Set<Integer> set = new HashSet<>();

        for(int i=0;i<n;i++){
            set.add(find(i));
        }
        return set.size();
    }
    // Time : O(n + E * k (n))
    // Space : O(n)
}
