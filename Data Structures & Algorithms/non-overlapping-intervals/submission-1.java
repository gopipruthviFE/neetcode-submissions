class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        int count = 0;
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);

        for(int i=1;i<n;i++){
            int[] last = list.get(list.size() - 1);
            int[] curr = intervals[i];

            if(last[1] > curr[0]){
                count++;
                last[1] = Math.min(last[1], curr[1]);
            }else{
                list.add(curr);
            }
        }

        return count;
    }
}
