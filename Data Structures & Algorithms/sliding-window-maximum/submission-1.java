class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        //Monotonically decreasing deque
        int n = nums.length;
        int[] res = new int[n - k + 1];

        Deque<Integer> dq = new ArrayDeque<>();

        for(int i=0;i<n;i++){
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]){
                dq.pollLast();
            }

            while(!dq.isEmpty() && dq.peekFirst() <= i - k){
                dq.pollFirst();
            }
            dq.offerLast(i);

            if(i - k + 1 >= 0){
                res[i - k + 1] = nums[dq.peekFirst()];
            }
        }

        return res;
    }
    // Time : O(n) <--> each element enters deque once and leaves atmost once
    // Space : O(n) <--> as we have took deque for tracking monotonically decreasing values
}
