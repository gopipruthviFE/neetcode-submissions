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
    public boolean canAttendMeetings(List<Interval> intervals) {
        if(intervals.size() == 0){
            return true;
        }
        Collections.sort(intervals, (a, b) -> Integer.compare(a.start, b.start));

        List<Interval> list = new ArrayList<>();
        list.add(intervals.get(0));

        for(int i=1;i<intervals.size();i++){
            Interval last = list.get(list.size() - 1);
            Interval curr = intervals.get(i);

            if(last.end > curr.start){
                return false;
            }else{
                list.add(curr);
            }
        }

        return true;
    }
}
