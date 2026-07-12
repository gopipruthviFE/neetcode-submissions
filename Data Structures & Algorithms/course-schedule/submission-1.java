class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        int count = 0;

        List<List<Integer>> list = new ArrayList<>();
        Queue<Integer> que = new LinkedList<>();
        int[] indegree = new int[numCourses];

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
            return false;
        }

        while(!que.isEmpty()){
            int size = que.size();
            for(int i=0;i<size;i++){
                int idx = que.poll();
                count++;
                for(int nbr : list.get(idx)){
                    indegree[nbr]--;
                    if(indegree[nbr] == 0){
                        que.offer(nbr);
                    }
                }
            }
        }

        return count == numCourses;
    }
}
