class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> list = new ArrayList<>();
        list.add(intervals[0]);

        for(int i=1;i<intervals.length;i++){
            int[] last = list.get(list.size() - 1);
            int[] curr = intervals[i];
            if(last[1] >= curr[0]){
                last[1] = Math.max(curr[1], last[1]);
            }else{
                list.add(curr);
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}
