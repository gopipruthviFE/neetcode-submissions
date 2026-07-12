class Solution {
    public int lastStoneWeight(int[] stones) {
        int n = stones.length;

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> Integer.compare(b, a));

        for(int stone : stones){
            pq.offer(stone);
        }

        while(pq.size() > 1){
            int first = pq.poll();
            int second = pq.poll();

            if(second < first){
                pq.offer(first - second);
            }
        }

        return pq.isEmpty() ? 0 : pq.peek();
    }

    // Time : O(nlogn)
    // Space : O(n)
}
