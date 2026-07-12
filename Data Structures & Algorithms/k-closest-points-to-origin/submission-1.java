class Solution {
    public int distanceSquared(int[] b){
        return (b[0] * b[0] + b[1] * b[1]);
    }
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(distanceSquared(b), distanceSquared(a)));

        for(int i=0;i<k;i++){
            pq.offer(points[i]);
        }

        for(int i=k;i<points.length;i++){
            pq.offer(points[i]);
            pq.poll();
        }

        int[][] res = new int[pq.size()][2];
        int size = pq.size();

        for(int i=0;i<size;i++){
            res[i] = pq.poll();
        }

        return res;
    }

    // Time : O(nLogk)
    // Space : O(logk)
}
