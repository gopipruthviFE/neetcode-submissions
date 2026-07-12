class MedianFinder {
    PriorityQueue<Integer> maxHeap;
    PriorityQueue<Integer> minHeap;

    public MedianFinder() {
        maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b, a));
        minHeap = new PriorityQueue<>();
    }
    
    public void addNum(int num) {
        maxHeap.offer(num);
        minHeap.offer(maxHeap.poll());
        if(minHeap.size() > maxHeap.size()){
            int top = minHeap.poll();
            maxHeap.offer(top);
        }
    }
    
    public double findMedian() {
        if((maxHeap.size() + minHeap.size()) % 2 == 0){
            return (maxHeap.peek() + minHeap.peek()) / 2.0 ;
        }
        return maxHeap.peek();
    }
}
