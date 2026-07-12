class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i=0;i<k;i++){
            pq.offer(nums[i]);
        }

        for(int i=k;i<nums.length;i++){
            pq.offer(nums[i]);// first add as min can be on top so far, so if we poll first we might drop the min
            pq.poll();
        }

        return pq.peek();
    }

    // Time : O(nLogk)
    // Space : O(logk)
}
