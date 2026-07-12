class TimeMap {
    Map<String, List<String[]>> map;

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        map.computeIfAbsent(key, k -> new ArrayList<>()).add(new String[]{ value, String.valueOf(timestamp)});
    }
    
    public String get(String key, int timestamp) {
        if(!map.containsKey(key)){
            return "";
        }
        List<String[]> list = map.get(key);
        int low = 0;
        int high = list.size() - 1;
        int ans = -1;

        while(low <= high){
            int mid = low + (high - low) / 2;
            int sortedTimeStamp = Integer.parseInt(list.get(mid)[1]);

            if(sortedTimeStamp <= timestamp){
                ans = mid;
                low = mid + 1;
            }else{
                high = mid - 1;
            }
        }
        return ans == -1 ? "" : list.get(ans)[0];
    }
}
