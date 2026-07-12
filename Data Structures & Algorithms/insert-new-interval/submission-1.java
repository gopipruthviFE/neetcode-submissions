class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int target = newInterval[0];

        int low = 0;
        int high = intervals.length - 1;

        int ans = intervals.length;

        while(low <= high){
            int mid = low + (high - low) / 2;

            if(intervals[mid][0] >= target){
                ans = mid;
                high = mid - 1;
            }else{
                low = mid + 1;
            }
        }

        if(ans < intervals.length && intervals[ans][0] == target){
            ans++;
        }

        List<int[]> sorted = new ArrayList<>();
        for(int i=0;i<ans;i++){
            sorted.add(intervals[i]);
        }
        sorted.add(newInterval);

        for(int i=ans;i<intervals.length;i++){
            sorted.add(intervals[i]);
        }

        List<int[]> list = new ArrayList<>();
        list.add(sorted.get(0));

        for(int i=1;i<sorted.size();i++){
            int[] last = list.get(list.size() - 1);
            int[] curr = sorted.get(i);

            if(last[1] >= curr[0]){
                last[1] = Math.max(last[1], curr[1]);
            }else{
                list.add(curr);
            }
        }

        return list.toArray(new int[list.size()][]);
    }
}
