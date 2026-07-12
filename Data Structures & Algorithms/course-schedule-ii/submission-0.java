class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        Queue<Integer> que = new LinkedList<>();
        int[] indegree = new int[numCourses];
        int count = 0;

        for(int i=0;i<numCourses;i++){
            list.add(new ArrayList<>());
        }

        for(int[] pre : prerequisites){
            list.get(pre[1]).add(pre[0]);
            indegree[pre[0]]++;
        }

        for(int i=0;i<numCourses;i++){
            if(indegree[i] == 0){
                que.offer(i);
            }
        }

        if(que.isEmpty()){
            return new int[]{};
        }

        while(!que.isEmpty()){
            int size = que.size();

            for(int i=0;i<size;i++){
                int idx = que.poll();
                res.add(idx);
                count++;

                for(int nbr : list.get(idx)){
                    indegree[nbr]--;
                    if(indegree[nbr] == 0){
                        que.offer(nbr);
                    }
                }
            }
        }
        int[] ans = new int[res.size()];

        if(count == numCourses){
            for(int i=0;i<res.size();i++){
                ans[i] = res.get(i);
            }

            return ans;
        }

        return new int[]{};
    }

    // Time : O(V + E)
    // Space : O(V + E)
}
