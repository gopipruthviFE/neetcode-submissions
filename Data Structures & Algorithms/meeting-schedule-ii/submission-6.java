/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));
        PriorityQueue<Interval> pq = new PriorityQueue<>((a, b) -> Integer.compare(a.end, b.end));

        for(int i=0;i<intervals.size();i++){
            if(!pq.isEmpty() && pq.peek().end <= intervals.get(i).start){
                Interval top = pq.poll();
            }
            pq.offer(intervals.get(i));
        }

        return pq.size();
    }
}
